package com.hospital.api.repository;



import com.hospital.api.model.PatientStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientStatusRepository extends JpaRepository<PatientStatus,Long> {
}
