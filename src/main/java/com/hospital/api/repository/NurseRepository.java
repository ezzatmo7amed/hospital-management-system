package com.hospital.api.repository;

import com.hospital.api.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NurseRepository extends JpaRepository<Nurse,Long> {

   List<Nurse> findAllByDeptName(String DeptName);

}
