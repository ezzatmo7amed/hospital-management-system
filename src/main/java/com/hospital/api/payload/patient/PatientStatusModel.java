package com.hospital.api.payload.patient;

import com.hospital.api.payload.nurse.NurseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientStatusModel {
    private Long id;
    private Double temperature;
    private Double thePressure;
    private Boolean isHeAllergic;
    private Boolean heartbeatRegular;
    private String newSymptoms;
    private Date followUpTime;
    private String note;
    private NurseModel nurse;
}
