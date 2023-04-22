package com.hospital.api.service.usermanagement;



import com.hospital.api.payload.userManagement.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto create(RoleDto model);
    RoleDto getById(Long id);
    List< RoleDto> getAll();
    RoleDto update(RoleDto model);

    List<RoleDto> addRoles(List<RoleDto> roles);
}
