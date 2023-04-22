package com.hospital.api.service.patient;






import com.hospital.api.payload.patient.PatientStatusDto;
import com.hospital.api.payload.patient.PatientStatusModel;

import java.util.List;

public interface PatientStatusService {

    PatientStatusDto create(PatientStatusDto patientStatusDto);
    PatientStatusDto getById(Long id);
    List<PatientStatusModel> getAll();
    List<PatientStatusDto> addAll(List<PatientStatusDto> patientStatusDtoList);
}
