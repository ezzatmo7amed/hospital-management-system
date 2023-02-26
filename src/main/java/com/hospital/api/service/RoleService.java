package com.hospital.api.service;



import com.hospital.api.payload.UserManagement.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto create(RoleDto model);
    RoleDto getById(Long id);
    List< RoleDto> getAll();
    RoleDto update(RoleDto model);
}
