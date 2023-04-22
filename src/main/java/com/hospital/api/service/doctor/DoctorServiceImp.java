package com.hospital.api.service.doctor;




import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.Doctor;
import com.hospital.api.model.Patient;
import com.hospital.api.model.PatientStatus;
import com.hospital.api.payload.doctor.DoctorDeptModel;
import com.hospital.api.payload.doctor.DoctorDto;
import com.hospital.api.payload.patient.PatientModel;
import com.hospital.api.payload.patient.PatientStatusDto;
import com.hospital.api.payload.patient.PatientStatusNote;
import com.hospital.api.repository.DoctorRepository;
import com.hospital.api.repository.PatientRepository;
import com.hospital.api.repository.PatientStatusRepository;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PatientStatusRepository pSRepository;

    @Override
    public DoctorDto create(DoctorDto doctorDto) {

        Doctor doctor = Mapper.map(doctorDto, Doctor.class);
        doctorRepository.save(doctor);
        return Mapper.map(doctor,DoctorDto.class);
    }

    @Override
    public DoctorDto getById(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()-> new NotFoundException(" Doctor Not Found With Id : "+id));
        return Mapper.map(doctor, DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        if(doctors.isEmpty()){
            throw new NotFoundException(" Doctors Not Found ..! ");
        }else {
            return Mapper.mapAll(doctors, DoctorDto.class);
        }

    }

    @Override
    public List<PatientModel> getDoctorPatients(Long doctorId) {

        List<Patient> patients = patientRepository.findByDoctor_IdAndExitDateIsNull(doctorId);

        if(patients.isEmpty()){
            throw new NotFoundException(" Patients Not Found With Doctor Id "+doctorId);
        }else {
            return Mapper.mapAll(patients, PatientModel.class);
        }
    }

    @Override
    public List<DoctorDeptModel> getByDeptName(String deptName) {
        List<Doctor> doctors = doctorRepository.findAllByDeptName(deptName);
        if (doctors.isEmpty()){
            throw new NotFoundException(" Department Not Found : "+deptName);
        }else {
            return Mapper.mapAll(doctors, DoctorDeptModel.class);
        }

    }

    @Override
    public List<DoctorDto> addAll(List<DoctorDto> docListDto) {

        List<Doctor> docList = Mapper.mapAll(docListDto, Doctor.class);
        doctorRepository.saveAll(docList);
        return Mapper.mapAll(docList,DoctorDto.class);
    }

    @Override
    public PatientStatusDto addNoteOnPatientStatus(PatientStatusNote model) {

         Long id = model.getId();
         PatientStatus patientStatus = pSRepository.findById(id).orElseThrow(()-> new NotFoundException(" Patient Status Not Found With Id : "+id));

          patientStatus.setNote(model.getNote());
              pSRepository.save(patientStatus);

        return Mapper.map(patientStatus,PatientStatusDto.class);
    }
}
