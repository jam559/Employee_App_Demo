package com.example.employee_app_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.employee_app_demo.entity.Employee;
import com.example.employee_app_demo.entity.Project;
import com.example.employee_app_demo.repository.ProjectRepository;

@SpringBootApplication
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> saveProjects(List<Project> projects) {
        return projectRepository.saveAll(projects);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteAllProjects() {
        projectRepository.deleteAll();
    }


}
