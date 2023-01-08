package com.springBootProject.services;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootProject.Exception.NotFoundException;
import com.springBootProject.entity.Employee;
import com.springBootProject.repositiory.EmployeeRepository;

@Service
public class EmployeeServiceimp implements EmployeeService {
 
    @Autowired
    private EmployeeRepository repository;

 
    @Override
    public List<Employee> findEmployees() {

        return (List<Employee>) repository.findAll();
    }
 
    @Override
    public Employee findEmployee(int employeeId) {

        Optional<Employee> findById = repository.findById(employeeId);

        Employee existingEmployee =     null;
        if(findById.isPresent()) {

            existingEmployee=findById.get();    
        }

    if(existingEmployee==null) {
        throw new NotFoundException("#.........Employee with id="+employeeId+" not found");
         }
      return existingEmployee;
    }
 
    @Override
    public Employee saveEmployee(Employee employee) {

        return repository.save(employee);
    }
 
    @Override
//    public Employee updateEmployee(int employeeId, Employee employee) {
//        Employee updateEmploye = reposirtory.updateEmployee( employeeId,employee);
//                if(updateEmploye==null) {
//            throw new NotFoundException("#.........Employee with id="+employeeId+" not found");
//        }
//        return updateEmploye;
//            }
 
    public Employee updateEmployee(int employeeId, Employee employee) {
        Optional<Employee> findById = repository.findById(employeeId);
 
      if(!findById.isPresent())        
      {
          throw new NotFoundException("#.........Employee with id="+employeeId+" not found");
        }

      Employee updateEmploye = findById.get();    
    if(updateEmploye==null) {
        throw new NotFoundException("#.........Employee with id="+employeeId+" not found");
    }

    updateEmploye.setEmployeeName(employee.getEmployeeName());
    updateEmploye.setEmployeeEmail(employee.getEmployeeEmail());
 
    return repository.save(updateEmploye);
        }

    @Override
//    public Employee deleteEmployee(int employeeId) {
//        Employee deleteEmploye = reposirtory.deleteEmployee( employeeId);
//        
//        if(deleteEmploye==null) {
//            throw new NotFoundException("#.........Employee with id="+employeeId+" not found");
//        }
//        
//        return deleteEmploye;
//   }
    public Employee deleteEmployee(int employeeId) {

        Optional<Employee> findById = repository.findById(employeeId);
 
          if(!findById.isPresent())        
          {
              throw new NotFoundException("#.........Employee with id="+employeeId+" not found");
            }

          Employee deleteEmploye = findById.get();    
        if(deleteEmploye==null) {
            throw new NotFoundException("#.........Employee with id="+employeeId+" not found");
        }

         repository.deleteById(employeeId);
         return deleteEmploye;
               }
        }






