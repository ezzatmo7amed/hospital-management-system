package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "division_name",nullable = false)
    private String name;
    @Column(name = "division_code",nullable = false)
    private String code;

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    List<Doctor> doctors;

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    List<Nurse> nurses;
}
