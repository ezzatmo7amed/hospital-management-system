package com.hospital.api.payload.patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientModel2 {

    private Long id;
    private String name;
    private String address;
    private int age;
    private String gender;
    private String currentDivision;
    private Date entryTime;
    private Date exitDate;
    private String transferTo;
    private String unifiedNumber;
}
