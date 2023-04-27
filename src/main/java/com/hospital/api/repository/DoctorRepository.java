package com.hospital.api.repository;




import com.hospital.api.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> findAllByDeptName(String deptName);


    @Query(value = "FROM Doctor d")
     List<Doctor> getAllDoctorsData();
}
