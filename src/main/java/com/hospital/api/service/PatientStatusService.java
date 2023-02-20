package com.hospital.api.service;


import com.hospital.api.payload.patient.PatientStatusDto;

import java.util.List;

public interface PatientStatusService {

    PatientStatusDto create(PatientStatusDto patientStatusDto);
    PatientStatusDto getById(Long id);
    List<PatientStatusDto> getAll();
    List<PatientStatusDto> addAll(List<PatientStatusDto> patientStatusDtoList);
}
