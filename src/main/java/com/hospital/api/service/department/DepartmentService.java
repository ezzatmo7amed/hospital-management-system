package com.hospital.api.service.department;






import com.hospital.api.payload.department.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create(DepartmentDto divDto);
    DepartmentDto getById(Long id);
    List<DepartmentDto> getAll();
    List<DepartmentDto> addDivList(List<DepartmentDto> divListDto);
}
