package com.hospital.api.model.usermanagement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.api.base.BaseEntity;
import com.hospital.api.model.Doctor;
import com.hospital.api.model.Nurse;
import com.hospital.api.model.Stuff;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"user_name"})
})
public class User extends BaseEntity<Long> {


   /* @Column(name = "name", nullable = false)
    private String name;*/
    @Column(name = "user_name", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

/*    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Nurse nurse;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Stuff stuff;*/

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinTable(name = "users_roles", joinColumns =
            {@JoinColumn(name = "user_id")}, inverseJoinColumns =
            {@JoinColumn(name = "role_id")})
    @JsonManagedReference
    private Set<Role> roles;
}