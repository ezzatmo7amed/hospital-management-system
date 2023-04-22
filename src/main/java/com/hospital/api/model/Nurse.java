package com.hospital.api.model;

import com.fasterxml.jackson.annotation.*;
import com.hospital.api.base.BaseStaff;
import com.hospital.api.model.usermanagement.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Setter
@Getter
@Entity
@Table(name = "nurse")
public class Nurse extends BaseStaff<Long> {



    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    @JsonBackReference
    private Department dept;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

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
