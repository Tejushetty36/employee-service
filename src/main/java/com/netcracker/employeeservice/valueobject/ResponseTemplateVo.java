package com.netcracker.employeeservice.valueobject;

import com.netcracker.employeeservice.entity.Department;
import com.netcracker.employeeservice.entity.Employee;

public class ResponseTemplateVo {

    Employee employee;
    Department department;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
