package com.hospital.api.service;





import com.hospital.api.payload.nurse.NurseDeptModel;
import com.hospital.api.payload.nurse.NurseDto;
import com.hospital.api.payload.nurse.PatientResNurseModel;

import java.util.List;

public interface NurseService {

    NurseDto create(NurseDto nurseDto);
    NurseDto getById(Long id);
    List<NurseDto> getAll();
    List<NurseDeptModel> getByDeptName(String deptName);
    List<PatientResNurseModel> getNursePatients(Long nurseId);

    List<NurseDto> addAll(List<NurseDto> nurseListDto);
}
