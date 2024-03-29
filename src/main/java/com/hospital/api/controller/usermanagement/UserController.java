package com.hospital.api.controller.usermanagement;


import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.usermanagement.User;
import com.hospital.api.payload.userManagement.UserDto;
import com.hospital.api.security.jwt.JwtGeneratorInterface;
import com.hospital.api.service.usermanagement.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    private final JwtGeneratorInterface jwtGenerator;


    @PostMapping("create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto model){

        return ResponseEntity.ok(userService.create(model));
    }

    @PostMapping("addUsers")
    public ResponseEntity<List<UserDto>> addUsers(@RequestBody List<UserDto> users){
        return ResponseEntity.ok(userService.addUsers(users));
    }
    @GetMapping(path = "{userId}/user")
    public ResponseEntity<UserDto> getById(@PathVariable(value = "userId") Long id){

        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("email")
    public ResponseEntity<UserDto> findByEmail(@RequestParam(value = "email") String email){
        return ResponseEntity.ok(userService.findByEmail(email));
    }
    @GetMapping("all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PutMapping("update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto model) {
        return new ResponseEntity<>(userService.update(model), HttpStatus.CREATED);
    }

    @DeleteMapping("{userId}")
    public String deleteUserById(@PathVariable(value = "userId") Long id){

       return userService.deleteUserById(id);
    }



    @PostMapping("login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserDto user){
        return ResponseEntity.ok(userService.login(user));
    }

}
