package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    // UC3 - actual list storage
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(0);

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(emp -> emp.id == empId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(
                idCounter.incrementAndGet(),
                empPayrollDTO.name,
                empPayrollDTO.salary);
        employeePayrollList.add(empData);
        return empData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = getEmployeePayrollDataById(empId);
        if (empData != null) {
            empData.name = empPayrollDTO.name;
            empData.salary = empPayrollDTO.salary;
        }
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.removeIf(emp -> emp.id == empId);
    }
}