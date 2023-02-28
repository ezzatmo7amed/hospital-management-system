package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.api.base.BaseAuditing;
import jakarta.persistence.*;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "patients", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"unified_number"})
})

public class Patient extends BaseAuditing<Long> {


    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "address" ,nullable = false)
    private String address;
    @Column(name = "unified_number" ,nullable = false)
    private String unifiedNumber;
    @Column(name = "age" ,nullable = false)
    private int age;
    @Column(name = "gender" ,nullable = false)
    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "exit_date" ,nullable = true)
    private Date exitDate;
    @Column(name = "current_division" ,nullable = false)
    private String currentDivision;
    @Column(name = "transfer_to_another_division" ,nullable = true)
    private String transferTo;



    //****************** relations *****************


    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    @JsonBackReference
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name = "building_id",referencedColumnName = "id")
    @JsonBackReference
    private DepartmentBuilding building;



    @ManyToMany(fetch = FetchType.EAGER,targetEntity = Nurse.class)
    @JoinTable(name="patient_nurse",joinColumns =
            {@JoinColumn(name="patient_id")},inverseJoinColumns =
            {@JoinColumn(name="nurse_id")})
    @JsonManagedReference
    private Set<Nurse> nurses ;

    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private List<PatientStatus> patientStatus;

    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
   private  List<MedicationsExaminations> examinations;

}
