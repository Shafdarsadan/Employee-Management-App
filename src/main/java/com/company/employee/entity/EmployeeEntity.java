package com.company.employee.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private LocalDate dateOfBirth;
	    private Double salary;
	    private String address;
	    private String role;
	    private LocalDate joiningDate;
	    private Double yearlyBonusPercentage;
}