package com.hospital.api.controller;


import com.hospital.api.payload.UserManagement.UserDto;
import com.hospital.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;



    @PostMapping("create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto model){

        return ResponseEntity.ok(userService.create(model));
    }
    @GetMapping(path = "{userId}/user")
    public ResponseEntity<UserDto> getById(@PathVariable(value = "userId") Long id){

        return new ResponseEntity(userService.getById(id), HttpStatus.FOUND);
    }
    @GetMapping("all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
    @PutMapping("update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto model) {
        return new ResponseEntity<>(userService.update(model), HttpStatus.CREATED);
    }

    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable(value = "userId") Long id){
        userService.deleteUserById(id);
    }
}
