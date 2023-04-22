package com.hospital.api.controller;




import com.hospital.api.payload.patient.PatientDto;
import com.hospital.api.payload.patient.PatientModel;
import com.hospital.api.service.patient.PatientService;
import io.swagger.v3.oas.annotations.Operation;

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
    public ResponseEntity<PatientDto> create(@RequestBody PatientDto patientDto){
        return  new ResponseEntity<>(service.create(patientDto), HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable(value = "id") Long id){
        return  ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("un/")
    public ResponseEntity<PatientModel> findByUnifiedNumber(@RequestParam (defaultValue = "unifiedNumber") String unifiedNumber){
        return ResponseEntity.ok(service.findByUnifiedNumber(unifiedNumber));
    }

    @PostMapping("addAll")
    public ResponseEntity<List<PatientDto>> addAll(@RequestBody List<PatientDto> model){
        return ResponseEntity.ok(service.addAll(model));
    }

    @Operation(summary = "Get All Patients In Hospital")
 /*   @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })*/
    @GetMapping("all/InHospital")
    public ResponseEntity<List<PatientModel>> getAllInHospital(){
        return new ResponseEntity<>(service.getAllInHospital(), HttpStatus.FOUND);
    }

    @GetMapping("all/OutHospital")
    public  ResponseEntity<List<PatientModel>> getAllOutHospital(){
        return ResponseEntity.ok(service.getAllOutHospital());
    }

    @GetMapping("count")
    public Long numberOfPatients(){
        return service.numberOfPatients();
    }
}
