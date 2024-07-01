package com.company.employee.serviceimplementation;

import com.company.employee.dto.EmployeeDto;
import com.company.employee.entity.EmployeeEntity;
import com.company.employee.entity.EmployeeNameAndId;
import com.company.employee.repository.EmployeeRepository;
import com.company.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplmnt implements EmployeeService {


    @Autowired
    ModelMapper converter;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeRepository.save(converter.map(employeeDto, EmployeeEntity.class));
        return  converter.map(employeeEntity,EmployeeDto.class);
    }

    @Override
    public Optional<EmployeeEntity> updateEmployee(Long id, EmployeeEntity employeeEntityDetails) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeEntityDetails.getName());
            employee.setDateOfBirth(employeeEntityDetails.getDateOfBirth());
            employee.setSalary(employeeEntityDetails.getSalary());
            employee.setAddress(employeeEntityDetails.getAddress());
            employee.setRole(employeeEntityDetails.getRole());
            employee.setJoiningDate(employeeEntityDetails.getJoiningDate());
            employee.setYearlyBonusPercentage(employeeEntityDetails.getYearlyBonusPercentage());
            return employeeRepository.save(employee);
        });
    }


    @Override
    public List<EmployeeNameAndId> getEmployee(String lookup) {
        if ("true".equalsIgnoreCase(lookup)) {
            return employeeRepository.getAllEmployeeNameAndId();
        } else {
            return List.of();
        }
    }

    public Mono<List<EmployeeDto>> getAll() {
        return  Mono.justOrEmpty(employeeRepository.findAll().stream().map(
                employeeEntity -> converter.map(employeeEntity, EmployeeDto.class)
        ).toList());
    }
}
