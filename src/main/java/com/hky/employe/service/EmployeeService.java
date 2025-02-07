package com.hky.employe.service;


import com.hky.employe.entity.Employee;
import com.hky.employe.repo.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeService {

    @Autowired
    private final EmployeeRepo employeeRepo;

    public Employee postEmplyee(Employee employee){
        return employeeRepo.save(employee);
    }


    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public void deleteEmployee(Long id){
        if (!employeeRepo.existsById(id)){
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }

        employeeRepo.deleteById(id);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }

    public Employee upadteEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();

            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setName(employee.getName());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setDepartment(employee.getDepartment());

            return employeeRepo.save(existingEmployee);
        }
        return null;
    }
}
