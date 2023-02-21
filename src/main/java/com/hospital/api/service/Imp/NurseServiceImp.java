package com.hospital.api.service.Imp;





import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.Nurse;
import com.hospital.api.model.Patient;
import com.hospital.api.payload.nurse.NurseDeptModel;
import com.hospital.api.payload.nurse.NurseDto;
import com.hospital.api.payload.nurse.PatientResNurseModel;
import com.hospital.api.repository.NurseRepository;
import com.hospital.api.repository.PatientRepository;
import com.hospital.api.service.NurseService;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class NurseServiceImp implements NurseService {

    private final NurseRepository nurseRepository;
    private final PatientRepository patientRepository;

    @Override
    public NurseDto create(NurseDto nurseDto) {
        Nurse nurse = Mapper.map(nurseDto, Nurse.class);
          nurseRepository.save(nurse);
        return Mapper.map(nurse,NurseDto.class);
    }

    @Override
    public NurseDto getById(Long id) {
        Nurse nurse = nurseRepository.findById(id).orElseThrow(()-> new NotFoundException(" Nurse Not Found With Id : "+id));
        return Mapper.map(nurse, NurseDto.class);
    }

    @Override
    public List<NurseDto> getAll() {

        List<Nurse> nurses = nurseRepository.findAll();
        if(nurses.isEmpty()) {
            throw new NotFoundException(" Nurses Not Found ..! ");
        }else {
            return Mapper.mapAll(nurses, NurseDto.class);

        }
    }

    @Override
    public List<NurseDeptModel> getByDeptName(String deptName) {
        List<Nurse> nurses = nurseRepository.findAllByDeptName(deptName);
        if(nurses.isEmpty()) {
            throw new NotFoundException(" Department Not Found : "+deptName);
        }else {
            return Mapper.mapAll(nurses, NurseDeptModel.class);

        }
    }

    @Override
    public List<PatientResNurseModel> getNursePatients(Long nurseId) {
        List<Patient> patients = patientRepository.findByNurseId(nurseId);
        if (patients.isEmpty()) {
            throw new NotFoundException(" Patients Not Found With Nurse Id " + nurseId);
        }else {

            return Mapper.mapAll(patients, PatientResNurseModel.class);
        }
    }

    @Override
    public List<NurseDto> addAll(List<NurseDto> nurseListDto) {
        List<Nurse> nurses = Mapper.mapAll(nurseListDto, Nurse.class);
        nurseRepository.saveAll(nurses);
        return Mapper.mapAll(nurses,NurseDto.class);
    }
}
