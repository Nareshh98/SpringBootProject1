package com.springBootProject.dao;

import java.util.List;

import com.springBootProject.entity.Employee;


 
public interface EmployeeDAO {
 
    public List<Employee> findEmployees();
    public Employee findEmployee(int employeeId);
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(int employeeId,Employee employee);
    public Employee deleteEmployee(int employeeId);

}

