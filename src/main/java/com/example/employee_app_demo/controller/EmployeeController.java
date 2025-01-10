package com.example.employee_app_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_app_demo.entity.Employee;
import com.example.employee_app_demo.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getEmployeeById/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId){
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/saveEmployees")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees){
        return employeeService.saveEmployees(employees);
    }

    @PutMapping("/updateEmployees")
    public List<Employee> updateEmployee(@RequestBody List<Employee> employees){
        return employeeService.updateEmployee(employees);
    }

    @DeleteMapping("/deleteEmployeeById/{empId}")
    public void deleteEmployeeById(@PathVariable Long empId){
        employeeService.deleteEmployeeById(empId);
    }

    @DeleteMapping("/deleteAllEmployees")
    public void deleteAll(){
        employeeService.deleteAll();
    }

    @PutMapping("/{empId}/project/{projectId}")
    public Employee assignProjectToEmployee(@PathVariable Long empId, @PathVariable Long projectId){
        return employeeService.assignProjectToEmployee(empId, projectId);
    }

}
