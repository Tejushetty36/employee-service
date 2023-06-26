package com.netcracker.employeeservice.service;

import com.netcracker.employeeservice.entity.Department;
import com.netcracker.employeeservice.entity.Employee;
import com.netcracker.employeeservice.repository.EmployeeRepo;
import com.netcracker.employeeservice.valueobject.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RefreshScope
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo empRepository;

    @Lazy
    @Autowired
    RestTemplate restTemplate;

    @Value("${microservice.department-service.endpoints.endpoint.uri}")
    private String DEPT_ENDPOINT_URL;

    @Override
    public Employee searchEmployee(long empId) {

        Employee emp = new Employee();
        if(empRepository.existsById(empId)) {
            emp = empRepository.findById(empId).get();
            return emp;
        }else{
            return emp;
        }

    }

    @Override
    public String createEmployee(Employee employee) {

        empRepository.save(employee);

        /*Department department = new Department();
        department.setDepartmentId(employee.getEmpDeptId());
        String deptResponse = restTemplate.postForObject(DEPT_ENDPOINT_URL+employee.getEmpDeptId(),department, String.class);*/
        return "Employee with id "+employee.getEmpId()+" and employee name "+employee.getEmpName()+
                " has been created";
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }

    @Override
    public String deleteEmployeeById(long empId) {
        if(empRepository.existsById(empId)) {
            empRepository.deleteById(empId);
            return "Employee with id "+empId+" has been successfully deleted";
        }else{
            return "Employee with id "+empId+" doesn't exist in database";
        }
    }

    @Override
    public ResponseTemplateVo getEmployeeWithDepartment(long empId) {

        Employee emp = null;
        if(empRepository.existsById(empId))
            emp = empRepository.findById(empId).get();
        Department department = restTemplate.getForObject(DEPT_ENDPOINT_URL+emp.getEmpDeptId(), Department.class);

        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        responseTemplateVo.setEmployee(emp);
        responseTemplateVo.setDepartment(department);

        return responseTemplateVo;
    }

    @Override
    public String updateEmployee(long empId, Employee employee) {
        Employee updateEmployee ;
        if(empRepository.existsById(empId))
            updateEmployee = empRepository.findById(empId).get();
        else
            return "Employee with id : "+empId+" doesn't exist.";

        updateEmployee.setEmpName(employee.getEmpName());
        updateEmployee.setEmpSalary(employee.getEmpSalary());
        updateEmployee.setEmpDeptId(employee.getEmpDeptId());

        empRepository.saveAndFlush(updateEmployee);

        return "Employee details with id: "+empId+" has been sucessfully updated.";
    }
}
