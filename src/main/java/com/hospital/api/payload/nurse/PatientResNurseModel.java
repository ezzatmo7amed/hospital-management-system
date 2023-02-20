package com.hospital.api.payload.nurse;

import com.hospital.api.payload.department.DepartmentBuildingDto;
import com.hospital.api.payload.MedicationsExaminationsDto;
import com.hospital.api.payload.patient.PatientStatusModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResNurseModel {

    private String name;
    private int age;
    private String gender;
    private String unifiedNumber;
    private String currentDivision;
    private String transferTo;
    private DocModel doctor;
    private DepartmentBuildingDto building;
    private List<PatientStatusModel> patientStatus;
    List<MedicationsExaminationsDto> examinations;


}
