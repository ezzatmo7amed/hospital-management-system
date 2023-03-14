package com.hospital.api.service.Imp;



import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.usermanagement.User;
import com.hospital.api.payload.userManagement.UserDto;
import com.hospital.api.repository.UserRepository;
import com.hospital.api.service.UserService;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto create(UserDto model) {
        try {

            Optional<User> duplicateMailCheck = userRepository.findByEmail(model.getEmail());
            Optional<User> duplicateUserNameCheck = userRepository.findByUserName(model.getUserName());

            if (duplicateMailCheck.isPresent() || duplicateUserNameCheck.isPresent()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A user with a duplicate National Or Email already exists !");
            }
            User user = Mapper.map(model, User.class);
            userRepository.save(user);

            return Mapper.map(user, UserDto.class);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"The Following Exception Occurred !");
        }
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException(" User Not Found With Id : "+id));
        return Mapper.map(user, UserDto.class);
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
        User user =userRepository.findById(userId).orElseThrow();
      //  user = Mapper.map(model, User.class);
        userRepository.save(user);
        return Mapper.map(user,UserDto.class);
    }

    @Override
    public void deleteUserById(Long id) {
        if(!getById(id).equals(null))
            userRepository.deleteById(id);

    }
}
