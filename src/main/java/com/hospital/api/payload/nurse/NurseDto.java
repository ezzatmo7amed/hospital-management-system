package com.hospital.api.payload.nurse;




import com.hospital.api.payload.department.DepartmentDto;
import com.hospital.api.payload.userManagement.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NurseDto {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String gender;
    private Date hireDate;
    private String position;
    private Long mgrId;
    private DepartmentDto dept;
    private UserDto user;

}
