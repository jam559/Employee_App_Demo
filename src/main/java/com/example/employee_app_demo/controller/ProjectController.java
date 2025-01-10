package com.example.employee_app_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_app_demo.entity.Employee;
import com.example.employee_app_demo.entity.Project;
import com.example.employee_app_demo.service.ProjectService;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/saveProjects")
    public List<Project> saveProjects(@RequestBody List<Project> projects){
        return projectService.saveProjects(projects);
    }

    @GetMapping("/getAllProjects")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @DeleteMapping("/deleteAllProjects")
    public void deleteAllProjects(){
        projectService.deleteAllProjects();
    }

}
