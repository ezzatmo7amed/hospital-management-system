package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.api.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "department_building")
public class DepartmentBuilding extends BaseEntity<Long> {



    @Column(name = "department_name",nullable = false)
    private String name;
    @Column(name = "room_number",nullable = false)
    private int roomNumber;

    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    List<Patient> patients;
}
