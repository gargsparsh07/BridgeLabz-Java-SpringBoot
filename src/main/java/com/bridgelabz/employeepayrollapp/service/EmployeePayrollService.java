package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return new ArrayList<>();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return new EmployeePayrollData(empId, "Dummy", 0.0);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        return new EmployeePayrollData(0, empPayrollDTO.name, empPayrollDTO.salary);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        return new EmployeePayrollData(empId, empPayrollDTO.name, empPayrollDTO.salary);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
    }
}