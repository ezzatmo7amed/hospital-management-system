package com.hospital.api.service.Imp;


import com.hospital.api.model.usermanagement.Role;
import com.hospital.api.payload.UserManagement.RoleDto;
import com.hospital.api.repository.RoleRepository;
import com.hospital.api.service.RoleService;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;


    @Override
    public RoleDto create(RoleDto model) {
        Role role = Mapper.map(model, Role.class);
        roleRepository.save(role);
        return Mapper.map(role, RoleDto.class);
    }

    @Override
    public RoleDto getById(Long id) {
        return null;
    }

    @Override
    public List<RoleDto> getAll() {
        return null;
    }

    @Override
    public RoleDto update(RoleDto model) {
        return null;
    }
}
