package com.hospital.api.payload.RestTemplateTest;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long postId;
    private Long id;
    private String name;
    @Email
    private String email;
    private String body;
}
