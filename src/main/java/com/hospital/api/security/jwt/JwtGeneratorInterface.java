package com.hospital.api.security.jwt;

import com.hospital.api.payload.userManagement.UserDto;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(UserDto user);
}
