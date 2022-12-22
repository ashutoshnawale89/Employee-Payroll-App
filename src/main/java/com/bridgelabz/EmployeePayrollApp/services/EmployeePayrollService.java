package com.bridgelabz.EmployeePayrollApp.services;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.exceptions.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.models.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.repositary.EmployeeRepo;
import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeeRepo employeeRepositary;
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> empData=employeeRepositary.findAll();
         return empData;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) throws Throwable {
        EmployeePayrollData empData=employeeRepositary.findById(empId).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new EmployeePayrollException("Employee Not Found. Please Check The All Data Carefully");
            }});

        return empData;
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(empPayrollDTO);
        employeeRepositary.save(empData);
        return empData;
    }


    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO empPayrollDTO) throws Throwable{
        EmployeePayrollData empData=employeeRepositary.findById(empId).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new EmployeePayrollException("Employee Not Found. Please Check The All Data Carefully");
            }});
      EmployeePayrollData empData1=new EmployeePayrollData(empId,empPayrollDTO);
      employeeRepositary.save(empData1);
        return empData1;
    }

    @Override
    public String deleteEmployeePayrollData(int empId) throws Throwable  {
        EmployeePayrollData empData=employeeRepositary.findById(empId).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new EmployeePayrollException("Employee Not Found. Please Check The All Data Carefully");
            }});
        employeeRepositary.deleteById(empId);
        return "Successfully Deleted ID Is  "+empId ;
    }
}
