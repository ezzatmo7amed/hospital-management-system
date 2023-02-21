package com.hospital.api.service.Imp;





import com.hospital.api.exception.NotFoundException;
import com.hospital.api.model.Department;
import com.hospital.api.payload.department.DepartmentDto;
import com.hospital.api.repository.DepartmentRepository;
import com.hospital.api.service.DepartmentService;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository deptRepository;

    @Override
    public DepartmentDto create(DepartmentDto divDto) {

        Department department = Mapper.map(divDto, Department.class);
        deptRepository.save(department);
        return Mapper.map(department, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getById(Long id) {
        Department department = deptRepository.findById(id).orElseThrow(()-> new NotFoundException(" Department Not Found With Id : "+id));
        return Mapper.map(department, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<Department> departments = deptRepository.findAll();
        if(departments.isEmpty()){
            throw new NotFoundException(" Departments Not Found ..! ");
        }else {

            return Mapper.mapAll(departments, DepartmentDto.class);
        }
    }

    @Override
    public List<DepartmentDto> addDivList(List<DepartmentDto> divListDto) {
        List<Department> deptList = Mapper.mapAll(divListDto, Department.class);
        deptRepository.saveAll(deptList);
        return Mapper.mapAll(deptList, DepartmentDto.class);
    }
}
