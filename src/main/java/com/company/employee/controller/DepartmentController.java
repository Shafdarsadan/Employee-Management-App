package com.company.employee.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.company.employee.entity.DepartmentEntity;
import com.company.employee.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	 @Autowired
	    private DepartmentService departmentService;

	    @PostMapping
	    public DepartmentEntity createDepartment(@RequestBody DepartmentEntity departmentEntity) {
	        return departmentService.createDepartment(departmentEntity);
	    }

	    @PutMapping("/{id}")
	    public Optional<DepartmentEntity> updateDepartment(@PathVariable Long id, @RequestBody DepartmentEntity departmentEntity) {
	        return departmentService.updateDepartment(id, departmentEntity);
	    }

	    @PutMapping("/change/{departmentId}/{employeeId}")
	    public DepartmentEntity changeEmployee(@PathVariable Long departmentId, @PathVariable long employeeId) {
		return departmentService.changeEmployee(departmentId,employeeId);
	    }

	    @DeleteMapping("/{id}")
	    public boolean deleteDepartment(@PathVariable Long id) {
	        return departmentService.deleteDepartment(id);
	    }

	    @GetMapping
	    public List<DepartmentEntity> getAllDepartments() {
	        return departmentService.getAllDepartments();
	    }

	    @GetMapping("/{id}")
	    public Optional<DepartmentEntity> getDepartment(@PathVariable Long id) {
	        return departmentService.getDepartment(id);
	    }
}
