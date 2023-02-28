package com.hospital.api.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseStaff <ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

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
    @Column(name = "manager_id" ,nullable = true)
    private Long mgrId;
}
