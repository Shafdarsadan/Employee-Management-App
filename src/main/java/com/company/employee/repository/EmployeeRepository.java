package com.company.employee.repository;

import com.company.employee.entity.DepartmentEntity;
import com.company.employee.entity.EmployeeEntity;
import com.company.employee.entity.EmployeeNameAndId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

      @Query("SELECT e.id AS id, e.name AS name FROM EmployeeEntity e")
      List<EmployeeNameAndId> getAllEmployeeNameAndId();
}
