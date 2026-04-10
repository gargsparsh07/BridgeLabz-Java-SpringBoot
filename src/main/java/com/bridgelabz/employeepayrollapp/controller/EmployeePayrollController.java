package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployees() {
        List<EmployeePayrollData> empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO response = new ResponseDTO("Get All Employee Payroll Data", empDataList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable int empId) {
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO response = new ResponseDTO("Get Employee Payroll Data for ID: " + empId, empData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO response = new ResponseDTO("Created Employee Payroll Data", empData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int empId,
                                                      @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO response = new ResponseDTO("Updated Employee Payroll Data for ID: " + empId, empData);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO response = new ResponseDTO(
                "Deleted Employee Payroll Data for ID: " + empId,
                "Employee deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}