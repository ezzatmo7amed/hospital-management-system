package com.hospital.api.service.Imp;




import com.hospital.api.model.DepartmentBuilding;
import com.hospital.api.payload.department.DepartmentBuildingDto;
import com.hospital.api.repository.DepartmentBuildingRepository;
import com.hospital.api.service.DepartmentBuildingService;
import com.hospital.api.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentBuildingServiceImp implements DepartmentBuildingService {
    private final DepartmentBuildingRepository dBRepository;
    @Override
    public DepartmentBuildingDto create(DepartmentBuildingDto dBDto) {
        DepartmentBuilding dB = Mapper.map(dBDto, DepartmentBuilding.class);
        dBRepository.save(dB);
        return Mapper.map(dB,DepartmentBuildingDto.class);
    }


}
