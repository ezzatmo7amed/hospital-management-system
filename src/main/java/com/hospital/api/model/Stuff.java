package com.hospital.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.api.base.BaseStaff;
import com.hospital.api.model.usermanagement.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Stuff extends BaseStaff<Long> {


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @JsonBackReference
    private Department dept;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
}
