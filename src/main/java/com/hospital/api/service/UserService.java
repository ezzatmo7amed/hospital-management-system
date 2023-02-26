package com.hospital.api.service;



import com.hospital.api.payload.UserManagement.UserDto;

import java.util.List;

public interface UserService {

    UserDto create(UserDto model);
    UserDto getById(Long id);
    List<UserDto> getAllUsers();
    UserDto update(UserDto model);

    void deleteUserById(Long id);
}
