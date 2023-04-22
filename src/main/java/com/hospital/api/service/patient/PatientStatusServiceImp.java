package com.hospital.api.service.patient;



import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.PatientStatus;
import com.hospital.api.payload.patient.PatientStatusDto;
import com.hospital.api.payload.patient.PatientStatusModel;
import com.hospital.api.repository.PatientStatusRepository;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientStatusServiceImp implements PatientStatusService {

    private final PatientStatusRepository patientStatusRepository;

    @Override
    public PatientStatusDto create(PatientStatusDto pSDto) {

        PatientStatus patientStatus = Mapper.map(pSDto, PatientStatus.class);
        patientStatusRepository.save(patientStatus);
        return Mapper.map(patientStatus, PatientStatusDto.class);
    }

    @Override
    public PatientStatusDto getById(Long id) {
        return null;
    }

    @Override
    public List<PatientStatusModel> getAll() {
        List<PatientStatus> patientStatuses = patientStatusRepository.findAll();
        if(patientStatuses.isEmpty()){
            throw new NotFoundException(" Patients Status Not Found ..! ");
        }else {
            return Mapper.mapAll(patientStatuses, PatientStatusModel.class);
        }


    }

    @Override
    public List<PatientStatusDto> addAll(List<PatientStatusDto> patientStatusDtoList) {
        return null;
    }
}
