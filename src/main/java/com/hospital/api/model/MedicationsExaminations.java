package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.api.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "medications_examinations")
public class MedicationsExaminations extends BaseEntity<Long> {



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
