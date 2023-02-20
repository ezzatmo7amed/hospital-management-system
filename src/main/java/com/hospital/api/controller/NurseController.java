package com.hospital.api.controller;

import com.hospital.api.payload.nurse.NurseDeptModel;
import com.hospital.api.payload.nurse.NurseDto;
import com.hospital.api.payload.nurse.PatientResNurseModel;
import com.hospital.api.service.NurseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/nurse/")
public class NurseController {

    private final NurseService service;


    @RequestMapping("create")
    public ResponseEntity<NurseDto> create(@RequestBody NurseDto nurseDto){
        return  new ResponseEntity<>(service.create(nurseDto), HttpStatus.CREATED);
    }

    @PostMapping("addAll")
    public ResponseEntity<List<NurseDto>> addAllNurses(@RequestBody List<NurseDto> model){
        return  new ResponseEntity<>(service.addAll(model), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<NurseDto> getById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.FOUND);
    }

    @GetMapping("all")
    public ResponseEntity<List<NurseDto>> getAll(){

        return new ResponseEntity<>(service.getAll(), HttpStatus.FOUND);
    }
    @GetMapping("byDept/")
    public ResponseEntity<List<NurseDeptModel>> getByDeptName(@RequestParam (defaultValue = "deptName") String deptName){
        return new ResponseEntity<>(service.getByDeptName(deptName), HttpStatus.FOUND);
    }



    @GetMapping("patients/{nurseId}")
    public  ResponseEntity<List<PatientResNurseModel>> getNursePatients(@PathVariable(value = "nurseId") Long nurseId){
        return new ResponseEntity<>(service.getNursePatients(nurseId), HttpStatus.FOUND);
    }
}
