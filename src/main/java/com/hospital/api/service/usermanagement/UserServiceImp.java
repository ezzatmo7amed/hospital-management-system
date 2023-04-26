package com.hospital.api.service.usermanagement;



import com.hospital.api.exception.NotFoundException;
import com.hospital.api.exception.ResourceExists;
import com.hospital.api.model.usermanagement.User;
import com.hospital.api.payload.userManagement.UserDto;
import com.hospital.api.repository.UserRepository;
import com.hospital.api.security.jwt.JwtGeneratorInterface;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final JwtGeneratorInterface jwtGenerator;

    @Override
    public UserDto create(UserDto model) {
        try {


            Optional<User> duplicateMailCheck = userRepository.findByEmail(model.getEmail());
            Optional<User> duplicateUserNameCheck = userRepository.findByUsername(model.getUsername());

            if (duplicateMailCheck.isPresent() || duplicateUserNameCheck.isPresent()) {
                throw new ResourceExists("A user with a duplicate National Or Email already exists !");
            }
            User user = Mapper.map(model, User.class);
            userRepository.save(user);

            return Mapper.map(user, UserDto.class);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"The Following Exception Occurred !");
        }
    }

    @Override
    public List<UserDto> addUsers(List<UserDto> users) {

        List<User> usersList = Mapper.mapAll(users, User.class);
        userRepository.saveAll(usersList);
        return Mapper.mapAll(usersList, UserDto.class);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException(" User Not Found With Id : "+id));
        return Mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()){
            throw new NotFoundException("Invalid Email .. !"+email);
        }else {
            return Mapper.map(user, UserDto.class);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            throw new NotFoundException("Users Not Found ..!");
        }else{
            return Mapper.mapAll(users, UserDto.class);
        }

    }

    @Override
    public UserDto update(UserDto model) {
        Long userId = model.getId();
        User user =userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User Not Found With Id:"+userId));

        String userEmail;

        if(model.getEmail() == null){
            userEmail = userRepository.findEmailWithId(userId);
            User user1 = Mapper.map(model, User.class);
            user1.setEmail(userEmail);
            user1.setPassword(model.getPassword().toUpperCase());
            userRepository.save(user1);
        }else {
            User user1 = Mapper.map(model, User.class);
            userRepository.save(user1);
        }

        return Mapper.map(user,UserDto.class);
    }

    @Override
    public String deleteUserById(Long id) {
        if(getById(id) == null){
            throw new RuntimeException("User Not Found With Id :"+id);
        }else {
            userRepository.deleteById(id);
           return "User Deleted With Id :"+id;
        }
    }

    @Override
    public Optional<User> getUserByNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(name, password);
        if(user == null){
            throw new NotFoundException("Invalid id and password");
        }
        return user;
    }

    @Override
    public Map<String, String> login(UserDto user) {

            Optional<User> user1 = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
                throw new NotFoundException("UserName or Password is Empty");
            } else if (user1.isEmpty()) {
                throw new NotFoundException("UserName or Password is Invalid");
            } else {

                return jwtGenerator.generateToken(user);
            }

    }
}
