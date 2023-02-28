package com.hospital.api.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseAuditing<ID> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @CreatedBy
    @Column(name = "created_by" ,nullable = true)
    private String createdBy;
    @CreatedDate
    @Column(name = "created_date" ,nullable = true)
    private LocalDateTime createdDate;
    @LastModifiedBy
    @Column(name = "last_modified_by" ,nullable = true)
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(name = "last_modified_date" ,nullable = true)
    private LocalDateTime lastModifiedDate;
}
