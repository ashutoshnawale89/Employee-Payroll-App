package com.bridgelabz.EmployeePayrollApp.dto;

import com.bridgelabz.EmployeePayrollApp.exceptions.EmployeePayrollExceptionalHandler;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class EmployeePayrollDTO {
        @NotEmpty(message = "Employee Name Cannot Be Null")
        public String name;
        @Min(value = 500,message = "Min Wage Should Be More Than 500")
        public long salary;
        public String gender;
        public LocalDate startDate;
        public String note;
        public String profilePic;
        public List<String> department;
}
