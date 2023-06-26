package com.netcracker.employeeservice.restapi;

import com.netcracker.employeeservice.entity.Employee;
import com.netcracker.employeeservice.service.EmployeeService;
import com.netcracker.employeeservice.valueobject.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/{eid}")
    public Employee getEmployeeById(@PathVariable("eid") long empId){
            Employee emp = employeeService.searchEmployee(empId);
            return emp;
            /*if(emp.getEmpId() == 0){
                return "Employee with id "+empId+" doesn't exist in the database.";
            }else{
                return emp.toString();
            }*/
    }

    @GetMapping(value = "/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(value = "/")
    public String createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping(value = "/{empId}")
    public String updateEmployee(@PathVariable("empId") long empId,@RequestBody Employee employee){
        return employeeService.updateEmployee(empId,employee);
    }

    @DeleteMapping(value = "/deleteById/{eid}")
    public String deleteEmployeeById(@PathVariable("eid") long empId){
        return employeeService.deleteEmployeeById(empId);
    }

    @GetMapping("/getEmployeeWithDept/{empId}")
    public ResponseTemplateVo searchEmployeeWithDepartment(@PathVariable("empId") long empId){
        ResponseTemplateVo responseTemplateVo = employeeService.getEmployeeWithDepartment(empId);
        return responseTemplateVo;
    }


}
