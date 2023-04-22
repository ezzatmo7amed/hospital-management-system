package com.hospital.api.service.patient;





import com.hospital.api.payload.patient.PatientDto;
import com.hospital.api.payload.patient.PatientModel;

import java.util.List;

public interface PatientService {


    PatientDto create(PatientDto patientDto);
    PatientDto getById(Long id);
    List<PatientModel> getAllInHospital();
    List<PatientModel> getAllOutHospital();
    List<PatientDto> addAll(List<PatientDto> patientListDto);

    PatientModel findByUnifiedNumber(String unifiedNumber);
    Long numberOfPatients();
}
