package com.hospital.api.repository;



import com.hospital.api.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PatientRepository extends JpaRepository<Patient,Long> {


    List<Patient> findByDoctor_IdAndExitDateIsNull(Long id);

    List<Patient> findAllByExitDateIsNull();

    List<Patient> findAllByExitDateIsNotNull();

    @Query(value = "select p.* from patients p inner join patient_nurse pn " +
            " on p.id = pn.patient_id " +
            " where p.exit_date is null And pn.nurse_id=:nurseId ",nativeQuery = true)
    List<Patient> findByNurseId(Long nurseId);


    Patient findByUnifiedNumber(String unifiedNumber);



}
