package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "phone" ,nullable = false)
    private String phone;
    @Column(name = "address" ,nullable = false)
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hire_date" ,nullable = false)
    private Date hireDate;
    @Column(name = "position" ,nullable = false)
    private String position;
    @Column(name = "gender" ,nullable = false)
    private String gender;
    @Column(name = "manager_id" ,nullable = false)
    private Long mgrId;


    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    @JsonBackReference
    private Department dept;


    // relation between doctor and patient


    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    List<Patient> patients;
}
