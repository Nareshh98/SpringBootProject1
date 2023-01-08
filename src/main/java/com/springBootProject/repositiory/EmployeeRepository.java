package com.springBootProject.repositiory;


import java.util.List; 
  
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springBootProject.entity.Employee; 
  
  
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {




    //select * from employee where EmployeeName="";





    public List<Employee>findByEmployeeName(String employeeName);

    public Employee findByEmployeeEmail(String employeeEmail);

    public Employee findByEmployeeNameAndEmployeeEmail(String employeeName ,String employeeEmail);
    public List<Employee>findByEmployeeNameOrEmployeeEmail(String employeeName,String employeeEmail );

    //jpa querys
    @Query(value="from Employee where employeeName=:employeeName",nativeQuery=false)
    public List<Employee> getEmployeeByName(String employeeName);
    @Query(value="from Employee where employeeEmail=:employeeEmail",nativeQuery=false)
    //nativequery is not mandatory
    public Employee getEmployeeByEmail(String employeeEmail);
    @Query(value="select * from employee",nativeQuery=true)
    public List<Employee> getAllEmployees();

}


