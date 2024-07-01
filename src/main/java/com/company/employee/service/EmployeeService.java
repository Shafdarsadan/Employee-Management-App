package com.company.employee.service;

import java.util.List;
import java.util.Optional;

import com.company.employee.dto.EmployeeDto;
import com.company.employee.entity.EmployeeEntity;
import com.company.employee.entity.EmployeeNameAndId;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService  {

    public EmployeeDto createEmployee(EmployeeDto employeeDto);
	Optional<EmployeeEntity> updateEmployee(Long id, EmployeeEntity employeeEntityDetails);
    List<EmployeeNameAndId> getEmployee(String lookup);
}
