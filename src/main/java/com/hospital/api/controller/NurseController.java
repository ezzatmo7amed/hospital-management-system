package com.hospital.api.controller;



import com.hospital.api.payload.nurse.NurseDeptModel;
import com.hospital.api.payload.nurse.NurseDto;
import com.hospital.api.payload.nurse.PatientResNurseModel;
import com.hospital.api.service.nurse.NurseService;
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
        return ResponseEntity.ok(service.create(nurseDto));
    }

    @PostMapping("addAll")
    public ResponseEntity<List<NurseDto>> addAllNurses(@RequestBody List<NurseDto> model){
        return  ResponseEntity.ok(service.addAll(model));
    }

    @GetMapping("{id}")
    public ResponseEntity<NurseDto> getById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(service.getById(id));
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
