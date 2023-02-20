package com.hospital.api.payload;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
