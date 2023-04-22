package com.hospital.api.payload.doctor;




import com.hospital.api.payload.department.DepartmentDto;
import com.hospital.api.payload.userManagement.UserDto;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long id;
    private String name;
    private String phone;
    private String address;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
    private String position;
    private String gender;
    private Long mgrId;
    private DepartmentDto dept;
    private UserDto user;
}
