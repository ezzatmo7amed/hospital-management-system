package com.hospital.api.controller;



import com.hospital.api.payload.department.DepartmentDto;
import com.hospital.api.service.department.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/department/")
public class DepartmentController {

    private final DepartmentService service;
    @PostMapping("create")
    public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto divDto){
        return  ResponseEntity.ok(service.create(divDto));
    }

    @GetMapping("{id}")

    public  ResponseEntity<DepartmentDto> getById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<DepartmentDto>> getAll(){
        return  ResponseEntity.ok(service.getAll());

    }
    @PostMapping("addList")
    public ResponseEntity<List<DepartmentDto>> addDivList(@RequestBody List<DepartmentDto> divListDto){
        return ResponseEntity.ok(service.addDivList(divListDto));
    }
}
