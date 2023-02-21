package com.hospital.api.controller;



import com.hospital.api.payload.department.DepartmentDto;
import com.hospital.api.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/dept/")
public class DepartmentController {

    private final DepartmentService service;
    @PostMapping("create")
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto divDto){
        return  new ResponseEntity<>(service.create(divDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")

    public  ResponseEntity<DepartmentDto> getById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.FOUND);
    }

    @GetMapping("all")
    public ResponseEntity<List<DepartmentDto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.FOUND);

    }
    @PostMapping("addAll")
    public ResponseEntity<List<DepartmentDto>> addDivList(@RequestBody List<DepartmentDto> divListDto){
        return  new ResponseEntity<>(service.addDivList(divListDto), HttpStatus.CREATED);
    }
}
