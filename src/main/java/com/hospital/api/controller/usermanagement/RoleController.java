package com.hospital.api.controller.usermanagement;


import com.hospital.api.payload.userManagement.RoleDto;
import com.hospital.api.service.usermanagement.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/role/")
public class RoleController {

    private final RoleService service;



    @PostMapping("create")
    public ResponseEntity<RoleDto> create (@RequestBody RoleDto model){
        return ResponseEntity.ok(service.create(model));
    }

    @PostMapping("addRoles")
    public  ResponseEntity<List<RoleDto>> addRoles(@RequestBody List<RoleDto> roles){
        return ResponseEntity.ok(service.addRoles(roles));
    }
    @GetMapping("all")
    public ResponseEntity<List<RoleDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
