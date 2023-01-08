package com.springBootProject.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when; 
  
import java.util.ArrayList;
import java.util.List; 
  
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.springBootProject.entity.Employee;
import com.springBootProject.repositiory.EmployeeRepository; 
  
  

class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeService service;

    @Mock
    EmployeeRepository repository; 
  
    @Test
    void findAllemployees() {

        Employee emp=new Employee(123,"naresh","naresh@gmail.com");
        Employee emp1=new Employee(124,"Akhil","Akhil@gmail.com");
        Employee emp2=new Employee(125,"Arjun","Arjun@gmail.com");        

        List<Employee> list=new ArrayList<>();
        list.add(emp);
        list.add(emp1);
        list.add(emp2); 
  
        when(repository.findAll()).thenReturn(list);

           List<Employee> emplist= service.findEmployees();

          assertEquals(3,emplist.size());

    } 
   
}


