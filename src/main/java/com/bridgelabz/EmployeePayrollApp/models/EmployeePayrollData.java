package com.bridgelabz.EmployeePayrollApp.models;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_payroll")
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    private String name;
    private long salary;

    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;


    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;


    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.gender=employeePayrollDTO.gender;
        this.startDate=employeePayrollDTO.startDate;
        this.note=employeePayrollDTO.note;
        this.profilePic=employeePayrollDTO.profilePic;
        this.department=employeePayrollDTO.department;
    }

    public EmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        this.employeeId = employeeId;
        this.name = empPayrollDTO.name;
        this.salary = empPayrollDTO.salary;
        this.gender=empPayrollDTO.gender;
        this.startDate=empPayrollDTO.startDate;
        this.note=empPayrollDTO.note;
        this.profilePic=empPayrollDTO.profilePic;
        this.department=empPayrollDTO.department;
    }
}
