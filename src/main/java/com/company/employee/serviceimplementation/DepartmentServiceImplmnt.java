package com.company.employee.serviceimplementation;

import java.util.List;
import java.util.Optional;
import com.company.employee.entity.EmployeeEntity;
import com.company.employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.employee.entity.DepartmentEntity;
import com.company.employee.repository.DepartmentRepository;
import com.company.employee.service.DepartmentService;

@Service
public class DepartmentServiceImplmnt implements DepartmentService {

    @Autowired
    ModelMapper converter;
	@Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

	@Override
    public DepartmentEntity createDepartment(DepartmentEntity  departmentEntity) {
//        DepartmentEntity departmentEntity = departmentRepository.save(converter.map(departmentDto,DepartmentEntity.class));
//         return converter.map(departmentEntity,DepartmentDto.class);
        return departmentRepository.save(departmentEntity);
    }

	@Override
    public Optional<DepartmentEntity> updateDepartment(Long id, DepartmentEntity departmentEntity) {
        return departmentRepository.findById(id).map(department -> {
            department.setName(departmentEntity.getName());
            department.setCreationDate(departmentEntity.getCreationDate());

//            if (departmentDto.getDepartmentLead() != null) {
//                EmployeeEntity employeeEntity = employeeRepository.findById(departmentDto.getDepartmentLead().getId()).orElse(null);
//                departmentEntity1.setDepartmentLead(employeeEntity);
//            }

            if (departmentEntity.getEmployeeEntities() != null){
                List<EmployeeEntity> employees = departmentEntity.getEmployeeEntities();
                EmployeeEntity employeeEntity = employees.get(0);
                employeeRepository.findById(employeeEntity.getId());
               department.setEmployeeEntities((List<EmployeeEntity>) employeeEntity);
            }

//            department.setEmployeeEntities(departmentEntity.getEmployeeEntities());

//          department.getEmployeeEntity().stream()
//                    .map(employeeEntity -> employeeRepository.save(employeeEntity));
            return departmentRepository.save(department);
        });
    }

	@Override
    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id) && departmentRepository.findById(id).get().getEmployeeEntities().isEmpty()) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

	@Override
    public List<DepartmentEntity> getAllDepartments() {
        return departmentRepository.findAll();
    }

	@Override
    public Optional<DepartmentEntity> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }


    @Override
    public DepartmentEntity changeEmployee(Long departmentId, Long employeeId) {
        // getting the old department using the employee id
        DepartmentEntity oldDepartment = departmentRepository.findByEmployeeEntitiesId(employeeId).get();
        System.out.println(oldDepartment);
        // getting the employee entity using employeeId
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        //removing the employee from old department
        oldDepartment.getEmployeeEntities().remove(employeeEntity);
        // saving the deparment to reflect in the db
        departmentRepository.save(oldDepartment);
        // getting the new department using the department  id
        DepartmentEntity newDepartment= departmentRepository.findById(departmentId).get();
        // adding the employee to the new department
        newDepartment.getEmployeeEntities().add(employeeEntity);
        // saving the departmetn after adding the employee
        departmentRepository.save(newDepartment);
        return newDepartment;
    }
}