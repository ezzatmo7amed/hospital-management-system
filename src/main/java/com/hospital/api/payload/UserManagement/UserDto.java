package com.hospital.api.payload.UserManagement;


import lombok.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String email;

    private Date createdAt;

    private Set<RoleDto> roleList;
}
