package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "department_building")
public class DepartmentBuilding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "division_name",nullable = false)
    private String name;
    @Column(name = "room_number",nullable = false)
    private int roomNumber;

    @OneToMany(mappedBy = "building")
    @JsonManagedReference
    List<Patient> patients;
}
