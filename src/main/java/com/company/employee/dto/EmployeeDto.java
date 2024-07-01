package com.company.employee.dto;

import com.company.employee.entity.DepartmentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private Double salary;
    private String address;
    private String role;
    private LocalDate joiningDate;
    private Double yearlyBonusPercentage;

}
