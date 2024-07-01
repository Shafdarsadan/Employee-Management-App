package com.company.employee.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
//import org.springframework.data.domain.Page;

import com.company.employee.dto.DepartmentDto;
import com.company.employee.entity.DepartmentEntity;
import com.company.employee.entity.EmployeeEntity;

public interface DepartmentService {

	public DepartmentEntity createDepartment(DepartmentEntity departmentEntity);
	Optional<DepartmentEntity> updateDepartment(Long id, DepartmentEntity departmentEntity);
	public boolean deleteDepartment(Long id);
	List<DepartmentEntity> getAllDepartments();
	Optional<DepartmentEntity> getDepartment(Long id);
	public DepartmentEntity changeEmployee(Long id, Long employeeId);

}
