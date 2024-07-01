package com.company.employee.controller;

//import java.util.List;
import java.util.List;
import java.util.Optional;

import com.company.employee.dto.EmployeeDto;
import com.company.employee.entity.EmployeeEntity;
import com.company.employee.entity.EmployeeNameAndId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.company.employee.serviceimplementation.EmployeeServiceImplmnt;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeeController {
	
	 @Autowired
	    private EmployeeServiceImplmnt employeeService;
	 
	 
	    @PostMapping
	    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
			log.info(employeeDto.toString());
	        return employeeService.createEmployee(employeeDto);
	    }

	    @PutMapping("/{id}")
	    public Optional<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntityDetails) {
	        return employeeService.updateEmployee(id, employeeEntityDetails);
	    }

		@GetMapping
	    public Mono<List<EmployeeDto>> getAll(){
			return  employeeService.getAll();
		}

     	@GetMapping("/param")
	    public List<EmployeeNameAndId> getEmployee(@RequestParam String lookup){
		return employeeService.getEmployee(lookup);
		}
}
