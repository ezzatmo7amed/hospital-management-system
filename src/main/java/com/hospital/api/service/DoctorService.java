package com.hospital.api.service;

import com.hospital.api.payload.doctor.DoctorDeptModel;
import com.hospital.api.payload.doctor.DoctorDto;
import com.hospital.api.payload.patient.PatientStatusDto;
import com.hospital.api.payload.patient.PatientModel;
import com.hospital.api.payload.patient.PatientStatusNote;

import java.util.List;

public interface DoctorService {

    DoctorDto create(DoctorDto doctorDto);
    DoctorDto getById(Long id);
    List<DoctorDto> getAll();
    List<PatientModel> getDoctorPatients(Long doctorId);
    List<DoctorDeptModel> getByDeptName(String deptName);

    List<DoctorDto> addAll(List<DoctorDto> docListDto);

    PatientStatusDto addNoteOnPatientStatus(PatientStatusNote model);

}
