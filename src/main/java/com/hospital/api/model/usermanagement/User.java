package com.hospital.api.model.usermanagement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.api.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class User extends BaseEntity<Long> {


    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "users_roles", joinColumns =
            {@JoinColumn(name = "user_id")}, inverseJoinColumns =
            {@JoinColumn(name = "role_id")})
    @JsonManagedReference
    private Set<Role> roleList;
}