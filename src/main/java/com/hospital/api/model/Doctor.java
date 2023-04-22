package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.api.base.BaseStaff;
import com.hospital.api.model.usermanagement.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "doctors")
public class Doctor extends BaseStaff<Long> {


    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    @JsonBackReference
    private Department dept;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    // relation between doctor and patient
    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    List<Patient> patients;
}
