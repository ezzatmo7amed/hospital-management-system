package com.hospital.api.payload.department;



import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentBuildingDto {
    private Long id;
    private String name;
    private int roomNumber;
}
