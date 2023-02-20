package com.hospital.api.controller;

import com.hospital.api.payload.patient.PatientDto;
import com.hospital.api.payload.patient.PatientModel;
import com.hospital.api.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/patient/")
public class PatientController {

    private final PatientService service;

    @PostMapping("create")
    public ResponseEntity<PatientDto> create(@RequestBody  PatientDto patientDto){
        return  new ResponseEntity<>(service.create(patientDto), HttpStatus.CREATED);

    }



    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.FOUND);
    }
    @GetMapping("un/")
    public ResponseEntity<PatientDto> findByUnifiedNumber(@RequestParam (defaultValue = "unifiedNumber") String unifiedNumber){
        return new ResponseEntity<>(service.findByUnifiedNumber(unifiedNumber), HttpStatus.FOUND);
    }

    @PostMapping("addAll")
    public ResponseEntity<List<PatientDto>> addAll(@RequestBody List<PatientDto> model){
        return  new ResponseEntity<>(service.addAll(model), HttpStatus.CREATED);
    }

    @GetMapping("all/InHospital")
    public ResponseEntity<List<PatientModel>> getAllInHospital(){
        return new ResponseEntity<>(service.getAllInHospital(), HttpStatus.FOUND);
    }

    @GetMapping("all/OutHospital")
    public  ResponseEntity<List<PatientModel>> getAllOutHospital(){
        return new ResponseEntity<>(service.getAllOutHospital(), HttpStatus.FOUND);
    }
}
