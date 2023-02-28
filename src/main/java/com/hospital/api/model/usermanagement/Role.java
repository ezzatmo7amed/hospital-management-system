package com.hospital.api.model.usermanagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.api.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "Roles")
public class Role extends BaseEntity<Long> {

    @Column(name = "role_name",nullable = false)
    private String name;
    @Column(name = "role_code",nullable = false)
    private String code;


    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY,targetEntity = User.class)
    @JoinTable(name="users_roles",joinColumns =
            {@JoinColumn(name="role_id")},inverseJoinColumns =
            {@JoinColumn(name="user_id")})
    @JsonBackReference
    private Set<User> users ;
}
