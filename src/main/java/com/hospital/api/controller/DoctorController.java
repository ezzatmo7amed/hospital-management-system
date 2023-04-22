package com.hospital.api.controller;






import com.hospital.api.payload.doctor.DoctorDeptModel;
import com.hospital.api.payload.doctor.DoctorDto;
import com.hospital.api.payload.patient.PatientModel;
import com.hospital.api.service.doctor.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/doctor/")
public class DoctorController {

    private final DoctorService service;
    @PostMapping("create")
    public ResponseEntity<DoctorDto> create(@RequestBody DoctorDto doctorDto){
        return  ResponseEntity.ok(service.create(doctorDto));

    }

    @PostMapping("addAll")
    public ResponseEntity<List<DoctorDto>> addDoctorsList(@RequestBody List<DoctorDto> docListDto){
        return ResponseEntity.ok(service.addAll(docListDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<DoctorDto>> getAll(){

        return ResponseEntity.ok(service.getAll());
    }



    @GetMapping("patients/{doctorId}")
    public  ResponseEntity<List<PatientModel>> getDoctorPatients(@PathVariable(value = "doctorId") Long doctorId){
        return ResponseEntity.ok(service.getDoctorPatients(doctorId));
    }

    @GetMapping("byDept/")
    public  ResponseEntity<List<DoctorDeptModel>> getByDeptName(@RequestParam (defaultValue = "deptName") String deptName) {
        return ResponseEntity.ok(service.getByDeptName(deptName));
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable(value = "id") Long id){
        return service.deleteById(id);
    }
}
