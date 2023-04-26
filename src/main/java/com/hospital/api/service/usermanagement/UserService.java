package com.hospital.api.service.usermanagement;



import com.hospital.api.model.usermanagement.User;
import com.hospital.api.payload.userManagement.UserDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    UserDto create(UserDto model);
    List<UserDto> addUsers(List<UserDto> users);
    UserDto getById(Long id);
    List<UserDto> getAllUsers();
    UserDto update(UserDto model);
    UserDto findByEmail(String email);

    String deleteUserById(Long id);

     Optional<User> getUserByNameAndPassword(String name, String password);


     Map<String, String> login(UserDto user);
}
