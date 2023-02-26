package com.hospital.api.repository;


import com.hospital.api.model.usermanagement.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
