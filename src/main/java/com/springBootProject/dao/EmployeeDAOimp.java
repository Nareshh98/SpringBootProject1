package com.springBootProject.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.springframework.stereotype.Repository;

import com.springBootProject.entity.Employee;
 

@Repository
public class EmployeeDAOimp implements EmployeeDAO {

    private static List<Employee> employees=new ArrayList<Employee>();
      private static int counter=1000000; 
    static {
           employees.add(new Employee(++counter,"admin","admin@wipro.com"));
           employees.add(new Employee(++counter,"Scott","scott@wipro.com"));
           employees.add(new Employee(++counter,"Mahesh","Mahesh@wipro.com"));
           }
 
    @Override
    public List<Employee> findEmployees() {
        return employees;
    }
 
    @Override
    public Employee findEmployee(int employeeId) {
        Employee employeeFound =null;

        for(Employee emplyoee:employees){
               if(emplyoee.getEmployeeId()==employeeId) {
                   employeeFound=emplyoee;
               break;
               }
        }
          return employeeFound; 
        }

 
    @Override
    public Employee saveEmployee(Employee employee) {
        Employee saveEmployee=employee;
        saveEmployee.setEmployeeId(++counter);
        employees.add(saveEmployee);
        return saveEmployee;
    }
 
/*        @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        Employee employeeFound =null;

        for(Employee employeeItr:employees){
               if(employeeItr.getEmployeeId()==employeeId)

               employeeItr.setEmployeeName(employee.getEmployeeName());
               employeeItr.setEmployeeName(employee.getEmployeeEmail());
 
                   
                   employeeFound=employeeItr;
               break;
               }          
          return employeeFound; 
        }                              */
     @Override
    public Employee updateEmployee(int employeeId, Employee employee) {
        Employee employeeFound=null;
 
        for(Employee employeeItr:employees) {
            if(employeeItr.getEmployeeId()==employeeId) {
                employeeItr.setEmployeeName(employee.getEmployeeName());
                employeeItr.setEmployeeEmail(employee.getEmployeeEmail());
                employeeFound=employeeItr;
                break;
            }
        }
 
        return employeeFound;
    }  
 
    @Override
    public Employee deleteEmployee(int employeeId) {
        Employee employeeFound=null;

        Iterator<Employee>itr=employees.iterator();
         while(itr.hasNext()) {
             Employee employee=itr.next();
             if(employee.getEmployeeId()== employeeId){
                 employeeFound=employee;
                    itr.remove();
                    break;
             }
         }
        return employeeFound;
    }
}
