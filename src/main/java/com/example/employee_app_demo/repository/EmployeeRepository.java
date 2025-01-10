package com.example.employee_app_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_app_demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    public Employee findByEmpId(Long empId);
    public void deleteByEmpId(Long empId);
}
