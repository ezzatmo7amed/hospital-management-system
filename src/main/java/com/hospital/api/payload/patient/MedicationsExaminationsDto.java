package com.hospital.api.payload;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicationsExaminationsDto {

    private Long id;

    private  String medication;

    private String medicalTests;

    private String rays;
}
