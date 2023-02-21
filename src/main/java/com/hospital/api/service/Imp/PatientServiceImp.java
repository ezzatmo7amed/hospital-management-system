package com.hospital.api.service.Imp;






import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.MedicationsExaminations;
import com.hospital.api.model.Patient;
import com.hospital.api.payload.patient.PatientDto;
import com.hospital.api.payload.patient.PatientModel;
import com.hospital.api.repository.MedicationsExaminationsRepository;
import com.hospital.api.repository.PatientRepository;
import com.hospital.api.service.PatientService;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImp implements PatientService {



    private final ModelMapper mapper;
    private final PatientRepository patientRepository;

    private final MedicationsExaminationsRepository medicationsExaminationsRepository;



    @Override
    public PatientDto create(PatientDto patientDto) {

        Patient patient = Mapper.map(patientDto, Patient.class);
        patientRepository.save(patient);

        List<MedicationsExaminations> examinations = mapper.map(patientDto.getExaminations(),new TypeToken<List<MedicationsExaminations>>(){}.getType());
        for (MedicationsExaminations m: examinations) {
            m.setPatient(patient);
        }
        medicationsExaminationsRepository.saveAll(examinations);
        return Mapper.map(patient, PatientDto.class);
    }

    @Override
    public PatientDto getById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()-> new NotFoundException(" Patient Not Found With Id : "+id));
        return Mapper.map(patient, PatientDto.class);
    }

    @Override
    public List<PatientModel> getAllInHospital() {

        List<Patient> patients = patientRepository.findAllByExitDateIsNull();
        if(patients.isEmpty()) {
            throw new NotFoundException(" Patients Not Found ..! ");
        }else {
            return Mapper.mapAll(patients, PatientModel.class);

        }
    }

    @Override
    public List<PatientModel> getAllOutHospital() {
        List<Patient> patients = patientRepository.findAllByExitDateIsNotNull();
        if(patients.isEmpty()) {
            throw new NotFoundException(" Patients Not Found ..! ");
        }else {
            return Mapper.mapAll(patients, PatientModel.class);

        }
    }

    @Override
    public List<PatientDto> addAll(List<PatientDto> patientListDto) {
        List<Patient> patients = Mapper.mapAll(patientListDto,Patient.class);
        patientRepository.saveAll(patients);
        return Mapper.mapAll(patients, PatientDto.class);
    }

    @Override
    public PatientModel findByUnifiedNumber(String unifiedNumber) {
        Patient patient = patientRepository.findByUnifiedNumber(unifiedNumber);
        if (patient == null) {
            throw new NotFoundException(" Patient Not Found With Unified Number : " + unifiedNumber);
        } else {
            return Mapper.map(patient, PatientModel.class);
        }
    }

    @Override
    public Long numberOfPatients() {
        return patientRepository.count();
    }
}
