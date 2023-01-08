package com.springBootProject.controller;


import java.net.URI;
import java.util.List; 
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springBootProject.entity.Employee;
import com.springBootProject.services.EmployeeService; 
  
 
@RestController
public class EmployeeController { 
  
    @Autowired
    private EmployeeService service;

     URI location;
    @GetMapping("/api/employees/{employeeId}")           

    public ResponseEntity<Employee>findEmployee(@PathVariable int employeeId) {

    Employee employee =service.findEmployee(employeeId);

        return new ResponseEntity<Employee>(employee,HttpStatus.OK);        
    }

    @RequestMapping(value="/api/employees",method=RequestMethod.GET)
    public List<Employee> findEmployee(){

        List<Employee> employees = service.findEmployees();
        return employees;
    }

    @PostMapping("/api/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        Employee saveEmployee = service.saveEmployee(employee);

        URI location =ServletUriComponentsBuilder.fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(saveEmployee.getEmployeeId())
                      .toUri();

         ResponseEntity<Employee> response=ResponseEntity.created(location).body(saveEmployee);

         return  response;

    } 
  
     @RequestMapping(value="/api/employees/{id}",method=RequestMethod.PUT)
      public ResponseEntity<Employee> UpdateEmployee(@PathVariable("id") int employeeId,@RequestBody Employee employee){
         Employee updatedEmployee = service.updateEmployee(employeeId, employee);

         return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);        

      }  


      @DeleteMapping("/api/employees/{id}")
      public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int employeeId) {
          Employee deleteEmployee= service.deleteEmployee(employeeId);
          return new ResponseEntity<Employee>(deleteEmployee,HttpStatus.OK);         
  
      }
   // to  see the test out (http://localhost:8070/h2-console) 
  
}






