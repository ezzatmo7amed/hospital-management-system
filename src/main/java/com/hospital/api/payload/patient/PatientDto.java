package com.hospital.api.payload.patient;




import com.hospital.api.payload.MedicationsExaminationsDto;
import com.hospital.api.payload.department.DepartmentBuildingDto;
import com.hospital.api.payload.doctor.DoctorDto;
import com.hospital.api.payload.nurse.NurseDto;
import lombok.*;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;
    private String name;
    private String address;
    private int age;
    private String gender;
    private Date entryTime;
    private Date exitDate;
    private String currentDivision;
    private String transferTo;
    private String unifiedNumber;
    private DoctorDto doctor;

    private DepartmentBuildingDto building;


    private List<PatientStatusModel> patientStatus;

    private Set<NurseDto> nurses ;
    private List<MedicationsExaminationsDto> examinations;

}
