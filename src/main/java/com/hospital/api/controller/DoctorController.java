package com.hospital.api.controller;


import com.hospital.api.payload.doctor.DoctorDeptModel;
import com.hospital.api.payload.doctor.DoctorDto;
import com.hospital.api.payload.patient.PatientModel;
import com.hospital.api.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return  new ResponseEntity<>(service.create(doctorDto), HttpStatus.CREATED);

    }

    @PostMapping("addAll")
    public ResponseEntity<List<DoctorDto>> addDoctorsList(@RequestBody List<DoctorDto> docListDto){
        return  new ResponseEntity<>(service.addAll(docListDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.FOUND);
    }

    @GetMapping("all")
    public ResponseEntity<List<DoctorDto>> getAll(){

        return new ResponseEntity<>(service.getAll(), HttpStatus.FOUND);
    }



    @GetMapping("patients/{doctorId}")
    public  ResponseEntity<List<PatientModel>> getDoctorPatients(@PathVariable(value = "doctorId") Long doctorId){
        return new ResponseEntity<>(service.getDoctorPatients(doctorId), HttpStatus.FOUND);
    }

    @GetMapping("byDept/")
    public  ResponseEntity<List<DoctorDeptModel>> getByDeptName(@RequestParam (defaultValue = "deptName") String deptName) {
        return new ResponseEntity<>(service.getByDeptName(deptName), HttpStatus.FOUND);
    }
}
