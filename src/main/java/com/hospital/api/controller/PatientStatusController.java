package com.hospital.api.controller;

import com.hospital.api.payload.patient.PatientStatusDto;
import com.hospital.api.payload.patient.PatientStatusNote;
import com.hospital.api.service.DoctorService;
import com.hospital.api.service.PatientStatusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/pStatus/")
public class PatientStatusController {

    private final PatientStatusService service;
    private final DoctorService doctorService;
    
    @PostMapping("create")
    public ResponseEntity<PatientStatusDto> create(@RequestBody PatientStatusDto pSDto){
        return new ResponseEntity<>(service.create(pSDto), HttpStatus.CREATED);
    }

    @PostMapping("addNote")
    public ResponseEntity<PatientStatusDto> addNoteOnPatientStatus(@RequestBody PatientStatusNote model){
        return new ResponseEntity<>(doctorService.addNoteOnPatientStatus(model), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<PatientStatusDto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.FOUND);
    }
}
