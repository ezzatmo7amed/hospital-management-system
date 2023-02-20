package com.hospital.api.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Setter
@Getter
@Entity
@Table(name = "nurse")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "phone" ,nullable = false)
    private String phone;
    @Column(name = "address" ,nullable = false)
    private String address;
    @Column(name = "hire_date" ,nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Column(name = "position" ,nullable = false)
    private String position;
    @Column(name = "gender" ,nullable = false)
    private String gender;
    @Column(name = "manager_id" ,nullable = false)
    private Long mgrId;

    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    @JsonBackReference
    private Department dept;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Patient.class)
    @JoinTable(name="patient_nurse",joinColumns =
            {@JoinColumn(name="nurse_id")},inverseJoinColumns =
            {@JoinColumn(name="patient_id")})
    @JsonManagedReference
    private Set<Patient> patients ;


    @OneToMany(mappedBy = "nurse")
    @JsonManagedReference
    List<PatientStatus> patientStatuses;

}
