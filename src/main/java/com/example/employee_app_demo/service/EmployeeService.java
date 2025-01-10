package com.example.employee_app_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.employee_app_demo.entity.Employee;
import com.example.employee_app_demo.entity.Project;
import com.example.employee_app_demo.repository.EmployeeRepository;
import com.example.employee_app_demo.repository.ProjectRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findByEmpId(empId);
    }

    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> updateEmployee(List<Employee> employees) {
        employeeRepository.deleteAll();
        return employeeRepository.saveAll(employees);
    }

    @Transactional
    public void deleteEmployeeById(Long empId) {
        employeeRepository.deleteByEmpId(empId);
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    public Employee assignProjectToEmployee(Long empId, Long projectId) {
        Employee employee = employeeRepository.findByEmpId(empId);
        Project project = projectRepository.findByProjectId(projectId);
        List<Project> projects = employee.getAssignedProjects();
        projects.add(project);
        employee.setAssignedProjects(projects);
        return employee;
    }

}
