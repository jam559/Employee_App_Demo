package com.example.employee_app_demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;
    private String name;
    private Integer age;
    private Long phoneNumber;
    private String designation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreign_addId", referencedColumnName = "addId")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreign_empId", referencedColumnName = "empId")
    private List<Device> device;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
        joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "empId"),
        inverseJoinColumns = @JoinColumn(name= "projectId", referencedColumnName = "projectId")
    )
    private List<Project> assignedProjects;
}
