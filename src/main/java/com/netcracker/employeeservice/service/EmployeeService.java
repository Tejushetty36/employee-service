package com.netcracker.employeeservice.service;

import com.netcracker.employeeservice.entity.Employee;
import com.netcracker.employeeservice.valueobject.ResponseTemplateVo;

import java.util.List;

public interface EmployeeService {

    public Employee searchEmployee(long empId);
    public String createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public String deleteEmployeeById(long empId);
    public ResponseTemplateVo getEmployeeWithDepartment(long empId);

    public String updateEmployee(long empId, Employee employee);
}
