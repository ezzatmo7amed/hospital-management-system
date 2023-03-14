package com.hospital.api.model.usermanagement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.api.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "Roles",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
public class Role extends BaseEntity<Long> {

    @Column(name = "name",nullable = false)
    private String name;


    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<User> users ;
}
