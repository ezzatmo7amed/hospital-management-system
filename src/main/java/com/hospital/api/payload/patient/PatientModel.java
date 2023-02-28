package com.hospital.api.payload.patient;



import com.hospital.api.payload.MedicationsExaminationsDto;
import com.hospital.api.payload.department.DepartmentBuildingDto;
import com.hospital.api.payload.nurse.DocModel;
import com.hospital.api.payload.nurse.NurseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientModel {
    private Long id;
    private String name;
    private String address;
    private int age;
    private String gender;
    private String currentDivision;
    private LocalDateTime createdDate;
    private Date exitDate;
    private String transferTo;
    private String unifiedNumber;
    private DocModel doctor;
    private DepartmentBuildingDto building;
    private Set<NurseModel> nurses ;
    private List<PatientStatusModel> patientStatus;
    private List<MedicationsExaminationsDto> examinations;

}
