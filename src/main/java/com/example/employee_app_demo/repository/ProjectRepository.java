package com.example.employee_app_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_app_demo.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

    public Project findByProjectId(Long projectId);

}
