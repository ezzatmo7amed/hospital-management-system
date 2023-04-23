package com.hospital.api;


import com.hospital.api.payload.userManagement.UserDto;
import com.hospital.api.service.usermanagement.UserServiceImp;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest


class HospitalApplicationTests {

    @Autowired
    private UserServiceImp userServiceImp;


    @Test
    void findByEmailNotFoundTest(){

        Optional<UserDto> user = Optional.ofNullable(userServiceImp.findByEmail("ezr@gmail.com"));
        Assert.assertEquals(false,user);
    }

    @Test
    void findByEmailTest(){

        Optional<UserDto> user = Optional.ofNullable(userServiceImp.findByEmail("ez@gmail.com"));
        Assert.assertEquals(true,user);
    }
    @Test
    void contextLoads() {
    }

}
