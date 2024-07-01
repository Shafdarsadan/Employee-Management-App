package com.company.employee.serviceimplementation;

import java.util.List;
import java.util.Optional;
import com.company.employee.dto.EmployeeDto;
import com.company.employee.entity.EmployeeEntity;
import com.company.employee.entity.EmployeeNameAndId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.employee.repository.EmployeeRepository;
import com.company.employee.service.EmployeeService;
import reactor.core.publisher.Mono;


@Service
public class EmployeeServiceImplmnt implements EmployeeService {

    @Autowired
    ModelMapper converter;

	@Autowired
    private EmployeeRepository employeeRepository;

	@Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
       EmployeeEntity  employeeEntity = employeeRepository.save(converter.map(employeeDto, EmployeeEntity.class));
        return  converter.map(employeeEntity,EmployeeDto.class);
    }

    @Override
    public Optional<EmployeeEntity> updateEmployee(Long id, EmployeeEntity employeeEntityDetails) {
        return Optional.empty();
    }

    @Override
    public List<EmployeeNameAndId> getEmployee(String lookup) {
        return employeeRepository.getAllEmployeeNameAndId();
    }

    public Mono<List<EmployeeDto>> getAll() {
        return  Mono.justOrEmpty(employeeRepository.findAll().stream().map(
                employeeEntity -> converter.map(employeeEntity, EmployeeDto.class)
        ).toList());
    }
}
