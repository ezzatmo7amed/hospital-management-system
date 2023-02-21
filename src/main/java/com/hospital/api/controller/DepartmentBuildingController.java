package com.hospital.api.controller;


import com.hospital.api.payload.department.DepartmentBuildingDto;
import com.hospital.api.service.DepartmentBuildingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/departmentBuilding/")
public class DepartmentBuildingController {

    private final DepartmentBuildingService service;

    @PostMapping("create")
    public ResponseEntity<DepartmentBuildingDto> create(@RequestBody DepartmentBuildingDto dBDto){
        return  new ResponseEntity<>(service.create(dBDto), HttpStatus.CREATED);
    }
}
