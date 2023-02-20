package com.hospital.api.payload.nurse;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NurseModel {
    private Long id;
    private String name;
    private String position;
}
