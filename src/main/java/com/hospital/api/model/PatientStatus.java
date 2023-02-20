package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "patients_status")
public class PatientStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "the_pressure")
    private Double thePressure;

    @Column(name = "is_he_allergic")
    private Boolean isHeAllergic;

    @Column(name = "is_he_heartbeat_regular")
    private Boolean heartbeatRegular;
    @Column(name = "are_there_new_symptoms")
    private String newSymptoms;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "follow_up_time" ,nullable = true)
    private Date followUpTime;

    @Column(name = "notes",length = 400,nullable = true)
    private String note;

  /*  @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonBackReference
    Patient patient;*/

 /*   @ManyToMany(fetch = FetchType.EAGER,targetEntity = Patient.class)
    @JoinTable(name="patient_patientStatus",joinColumns =
            {@JoinColumn(name="patientStatus_id")},inverseJoinColumns =
            {@JoinColumn(name="patient_id")})
    @JsonManagedReference*/
    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "nurse_id",referencedColumnName = "id")
    @JsonBackReference
    private Nurse nurse;
}
