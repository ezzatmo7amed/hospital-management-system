package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "medications_examinations")
public class MedicationsExaminations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medication" ,length = 400)
    private  String medication;
    @Column(name = "medical_tests" ,length = 400)
    private String medicalTests;
    @Column(name = "rays" ,length = 200)
    private String rays;

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonBackReference
    private Patient patient;
}
