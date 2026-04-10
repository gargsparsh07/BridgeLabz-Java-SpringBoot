package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private List<EmployeePayrollDTO> employeeList = new ArrayList<>();

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployees() {
        ResponseDTO response = new ResponseDTO("Get All Employee Payroll Data", employeeList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployee(@PathVariable int id) {
        EmployeePayrollDTO employee = employeeList.size() > id ? employeeList.get(id) : null;
        ResponseDTO response = new ResponseDTO("Get Employee Payroll Data for ID: " + id, employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        employeeList.add(empPayrollDTO);
        ResponseDTO response = new ResponseDTO("Created Employee Payroll Data", empPayrollDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployee(@PathVariable int id,
                                                      @RequestBody EmployeePayrollDTO empPayrollDTO) {
        if (employeeList.size() > id) {
            employeeList.set(id, empPayrollDTO);
        }
        ResponseDTO response = new ResponseDTO("Updated Employee Payroll Data for ID: " + id, empPayrollDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id) {
        EmployeePayrollDTO removed = null;
        if (employeeList.size() > id) {
            removed = employeeList.remove(id);
        }
        ResponseDTO response = new ResponseDTO("Deleted Employee Payroll Data for ID: " + id, removed);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}