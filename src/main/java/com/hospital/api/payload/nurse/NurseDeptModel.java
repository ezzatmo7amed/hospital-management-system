package com.hospital.api.payload.nurse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NurseDeptModel {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private String gender;
    private Date hireDate;
    private String position;
    private Long mgrId;
}
