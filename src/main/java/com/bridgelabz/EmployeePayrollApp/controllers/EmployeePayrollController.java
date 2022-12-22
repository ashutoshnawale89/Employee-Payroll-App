package com.bridgelabz.EmployeePayrollApp.controllers;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayrollApp.models.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.services.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList=null;
        empDataList=employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO=new ResponseDTO("Get Call Successful ",empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) throws Throwable {
        EmployeePayrollData empDataList=null;
        empDataList = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO=new ResponseDTO("Get Call Successfullly ",empDataList);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
             @Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData=null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO=new ResponseDTO("Created Employee Payroll Data Successfully ",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
            @RequestBody EmployeePayrollDTO empPayrollDTO) throws Throwable {
        EmployeePayrollData empData=null;
        empData =employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO respDTO=new ResponseDTO("Updated Employee Payroll Data Successfully ",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(
            @PathVariable("empId") int empId) throws Throwable {
        String empData=null;
        empData=employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO=new ResponseDTO("Deleted Employee Payroll Data ",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }
}
