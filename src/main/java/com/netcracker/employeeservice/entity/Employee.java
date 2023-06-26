package com.netcracker.employeeservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "nc_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long empId;
    private String empName;
    private float empSalary;
    private int empDeptId;

    public Employee() {
    }

    public Employee(long empId, String empName, float empSalary, int empDeptId) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDeptId = empDeptId;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(int empDeptId) {
        this.empDeptId = empDeptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empDeptId=" + empDeptId +
                '}';
    }
}
