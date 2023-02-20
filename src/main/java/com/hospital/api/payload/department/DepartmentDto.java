package com.hospital.api.payload.department;


import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    private Long id;
    private String name;
    private String code;
   // List<DoctorDto> doctors;
}
