package com.hospital.api.payload.userManagement;


import jakarta.validation.constraints.Email;
import lombok.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
  //  private String name;
    private String username;
    private String password;
    @Email
    private String email;
    private Date createdAt;
    private Set<RoleDto> roles;
}
