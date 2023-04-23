package com.hospital.api.model.usermanagement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.api.base.BaseEntity;
import com.hospital.api.model.Doctor;
import com.hospital.api.model.Nurse;
import com.hospital.api.model.Stuff;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {



    @Column(name = "user_name",unique = true, nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Email
    @Column(name = "email",unique = true, nullable = false)
    private String email;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdAt;



    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinTable(name = "users_roles", joinColumns =
            {@JoinColumn(name = "user_id")}, inverseJoinColumns =
            {@JoinColumn(name = "role_id")})
    @JsonManagedReference
    private Set<Role> roles;
}