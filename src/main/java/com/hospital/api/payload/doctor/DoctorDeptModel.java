package com.hospital.api.payload.doctor;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDeptModel {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private Date hireDate;
    private String position;
    private String gender;
    private Long mgrId;
}
