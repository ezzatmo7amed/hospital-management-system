package com.hospital.api.model.RestTemplateTest;

import com.hospital.api.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity<Long> {

    private Long postId;
    private String name;
    @Email
    private String email;
    @Column(name = "body",columnDefinition = "varchar(500)")
    private String body;
}