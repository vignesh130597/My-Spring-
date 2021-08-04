package com.spring.postgres.service;

import com.spring.postgres.dto.EmployeeRequest;
import com.spring.postgres.exception.APPException;
import com.spring.postgres.modal.Employees;
import com.spring.postgres.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public ResponseEntity<List<Employees>> getAllEmployee() throws APPException {
        List<Employees> eList = employeeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(eList);
    }

    public ResponseEntity<Employees> getEmployeeById(Long id) throws APPException {
        Employees employees = employeeRepository.findById(id).orElseThrow(() -> new APPException("Employee ID Not Found"));
        return ResponseEntity.status(HttpStatus.OK).body(employees);

    }

    public ResponseEntity createEmployees(@RequestBody EmployeeRequest employeeRequest) throws APPException{
        Employees cEmployee = new Employees();
        cEmployee.setId(employeeRequest.getId());
        cEmployee.setFirstName(employeeRequest.getFirstName());
        cEmployee.setLastName(employeeRequest.getLastName());
        cEmployee.setEmail(employeeRequest.getEmail());
        Employees lEmployee = employeeRepository.save(cEmployee);
        return ResponseEntity.status(HttpStatus.OK).body(lEmployee);

    }

    public ResponseEntity<Employees> updateEmployee(Long id, EmployeeRequest employeeRequest) throws  APPException{
        Employees employees = employeeRepository.findById(id).orElseThrow(() -> new APPException("Employee Not Found"));
        employees.setId(employeeRequest.getId());
        employees.setFirstName(employeeRequest.getFirstName());
        employees.setLastName(employeeRequest.getLastName());
        employees.setEmail(employeeRequest.getEmail());
        Employees employees1 = employeeRepository.save(employees);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    public  ResponseEntity<Employees> deleteEmployees(Long id){
        Employees employees = employeeRepository.findById(id).orElseThrow(() -> new APPException("Employee id Not Found"));
        employeeRepository.delete(employees);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }
}
