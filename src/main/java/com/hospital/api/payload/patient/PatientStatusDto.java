package com.hospital.api.payload.patient;



import com.hospital.api.payload.nurse.NurseModel;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientStatusDto {

    private Long id;
    private Double temperature;
    private Double thePressure;
    private Boolean isHeAllergic;
    private Boolean heartbeatRegular;
    private String newSymptoms;
    private Date followUpTime;
    private String note;
    private PatientDto patient;
    private NurseModel nurse;


}
