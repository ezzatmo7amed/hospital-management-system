package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.api.base.BaseEntity;
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
public class PatientStatus extends BaseEntity<Long> {


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
    @Column(name = "follow_up_time")
    private Date followUpTime;

    @Column(name = "notes",length = 400)
    private String note;

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "nurse_id",referencedColumnName = "id")
    @JsonBackReference
    private Nurse nurse;
}
