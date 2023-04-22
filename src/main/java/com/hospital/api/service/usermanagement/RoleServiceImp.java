package com.hospital.api.service.usermanagement;


import com.hospital.api.exception.NotFoundException;
import com.hospital.api.exception.ResourceExists;
import com.hospital.api.model.usermanagement.Role;
import com.hospital.api.payload.userManagement.RoleDto;
import com.hospital.api.repository.RoleRepository;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;


    @Override
    public RoleDto create(RoleDto model) {
        Optional<Role> checkRoleName = roleRepository.findByName(model.getName());
           if(checkRoleName.isPresent()){
               throw  new ResourceExists("The Role Is Already Exist..");
           }else {
               Role role = Mapper.map(model, Role.class);
               roleRepository.save(role);
               return Mapper.map(role, RoleDto.class);
           }

    }

    @Override
    public RoleDto getById(Long id) {
        return null;
    }

    @Override
    public List<RoleDto> getAll() {
        List<Role> roles = roleRepository.findAll();
        if(roles.isEmpty())
            throw new NotFoundException("Roles Not Found ..!");
        else{
            return Mapper.mapAll(roles, RoleDto.class);
        }

    }

    @Override
    public RoleDto update(RoleDto model) {
        return null;
    }

    @Override
    public List<RoleDto> addRoles(List<RoleDto> roles) {

        List<Role> roleList = Mapper.mapAll(roles,Role.class);

        roleRepository.saveAll(roleList);
        return Mapper.mapAll(roleList, RoleDto.class);
    }
}
