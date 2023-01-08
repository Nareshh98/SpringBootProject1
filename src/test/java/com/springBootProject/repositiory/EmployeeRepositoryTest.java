package com.springBootProject.repositiory;

import java.util.List;
import java.util.Optional; 
  
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springBootProject.entity.Employee; 
  

  

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository; 
  
    @Test
    @Order(1)
    void testSaveEmployee() {
        System.out.println("##.........saveEmployee testcase");
        Employee employee=new Employee("naresh","naresh@wipro.com");
        repository.save(employee);
        employee=new Employee("Ravi","ravi@wipro.com");
        repository.save(employee);
        employee=new Employee("Akhil","akhil@wipro.com");
        repository.save(employee);
        employee=new Employee("naresh","naresh123@wipro.com");
        repository.save(employee);
        employee=new Employee("Raj","raj@wipro.com");
        repository.save(employee);
    }
    @Test
    @Order(2)
    void testGetEmployee() {
        System.out.println("##.........getEmployee testcase");
        Optional<Employee> findById = repository.findById(1);
        if(findById.isPresent()) {
            Employee employee=findById.get();
            System.out.println("__________Employee Details:"+employee);
        }

    }
    @Test
    @Order(7)
    void testGetAllEmployees() {
        System.out.println("##.........GET ALL Employee testcase");
        Iterable<Employee> employees = repository.findAll();
        for(Employee employee:employees) {
            System.out.println("_____________Employee details:"+employee);
        }
    }

    @Test
    @Order(3)
    void testDeleteEmployee() {
        System.out.println("##.........DELETE Employee testcase");
        repository.deleteById(2);
    }
    @Test
    @Order(4)
    void testfindByEmployeeNameAndEmail() {
        System.out.println("**......... FIND by Employee (NAME and Email) testcase");
        Employee employees=repository.findByEmployeeNameAndEmployeeEmail("naresh","naresh@wipro.com");

            System.out.println("_____________Employee details:"+ employees);
        }

    @Test
    @Order(5)
    void testfindByEmployeeNameOrEmail() {
        System.out.println("##......... FIND by Employee (NAME or Email) testcase");
        List<Employee> employees=repository.findByEmployeeNameOrEmployeeEmail("Akhil","raj@wipro.com");
        for(Employee employee:employees) {
            System.out.println("_____________Employee details:"+ employee);
        }
    }
    @Test
    @Order(6)
    void testfindByEmployeeName() {
        System.out.println("##......... Employee name testcase");
        List<Employee> employees = repository.findByEmployeeName("naresh");
        for(Employee employee:employees) {
            System.out.println("_____________Employee details:"+employee);
        }
    }
    @Test
    @Order(8)
    void testfindByEmployeeEmail() {
        System.out.println("##......... Employee mail testcase");
        Employee employees = repository.findByEmployeeEmail("Raj@wipro.com");

            System.out.println("_____________Employee details:"+employees);

    }
    @Test
    @Order(9)
    void testGetEmployeeByName() {
        System.out.println("##......... Employee by name testcase");
        List<Employee> employees = repository.getEmployeeByName("naresh");
        for(Employee employee:employees) {
            System.out.println("_____________Employee details:"+employee);
        }
    }
    @Test
    @Order(10)
    void testGetEmployeeByEmail() {
        System.out.println("##......... Employee by mail testcase");
        Employee employees = repository.getEmployeeByEmail("naresh@wipro.com");

            System.out.println("_____________Employee details:"+employees);

    }
    @Test
    @Order(11)
    void findAllEmployes() {
        System.out.println("##........find all the Employee  testcase");

        Iterable<Employee> employees  =repository.getAllEmployees();
        for(Employee employee:employees) {
            System.out.println("_____________Employee details:"+employee);
        }
    }
}

