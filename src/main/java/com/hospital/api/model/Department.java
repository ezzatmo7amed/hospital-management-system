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
@Table(name = "departments")
public class Department extends BaseEntity<Long> {

    @Column(name = "department_name",nullable = false)
    private String name;
    @Column(name = "department_code",nullable = false)
    private String code;

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    List<Doctor> doctors;

    @OneToMany(mappedBy = "dept")
    @JsonManagedReference
    List<Nurse> nurses;
}
