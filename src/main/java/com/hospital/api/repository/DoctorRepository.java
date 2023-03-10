package com.hospital.api.repository;




import com.hospital.api.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findAllByDeptName(String deptName);


}
