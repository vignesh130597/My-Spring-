package com.spring.postgres.controller;

import com.spring.postgres.dto.Constants;
import com.spring.postgres.dto.EmployeeGenericResponse;
import com.spring.postgres.dto.EmployeeRequest;
import com.spring.postgres.dto.EmployeeValidation;
import com.spring.postgres.exception.APPException;
import com.spring.postgres.modal.Employees;
import com.spring.postgres.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeValidation employeeValidation;

    @GetMapping
    public Object getAllEmployees(){
        EmployeeGenericResponse eResponse = new EmployeeGenericResponse();
            try {
                ResponseEntity<List<Employees>> listEmployees = employeeService.getAllEmployee();
                return new ResponseEntity<>(listEmployees.getBody(), HttpStatus.OK);
            }
            catch (APPException e) {
                System.out.println("Exception occured");
                eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
                eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
                eResponse.setMessage(e.getMessage());
                return new ResponseEntity<>(eResponse, HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
                eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
                eResponse.setMessage(e.getMessage());
                return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
            }

    }

    @GetMapping("/{id}")
    public Object getEmployeesById(@PathVariable("id") Long id){
        EmployeeGenericResponse eResponse = new EmployeeGenericResponse();
        try {
            ResponseEntity<Employees> listEmployees = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(listEmployees.getBody());
        }
        catch (APPException e) {
            eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
            eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
            eResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(eResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
            eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
            eResponse.setMessage(e.getMessage());
            return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity createEmployees(@RequestBody EmployeeRequest employeeRequest){
        EmployeeGenericResponse eResponse = new EmployeeGenericResponse();
        try {
            String msg = employeeValidation.employeeValidation(employeeRequest);
            if (!msg.isEmpty()) {
                eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
                eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
                eResponse.setMessage(msg);
                return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
            }
            ResponseEntity<Employees> employeeResponse = employeeService.createEmployees(employeeRequest);
            eResponse.setStatus(Constants.SUCCESS_STATUS);
            eResponse.setError(Constants.SUCCESS_MESSAGE);
            eResponse.setMessage(Constants.USER_CREATED_SUCCESS);
            return new ResponseEntity(eResponse, HttpStatus.OK);
        }
        catch (APPException e) {
            eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
            eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
            eResponse.setMessage(e.getMessage());
            return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
            eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
            eResponse.setMessage(e.getMessage());
            return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Object updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest){
        EmployeeGenericResponse eResponse = new EmployeeGenericResponse();
        try {
            String msg = employeeValidation.employeeValidationForUpdate(id, employeeRequest);
            if (!msg.isEmpty()) {
                eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
                eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
                eResponse.setMessage(msg);
                return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
            }
            ResponseEntity<Employees> employeeResponse = employeeService.updateEmployee(id, employeeRequest);
            eResponse.setStatus(Constants.SUCCESS_STATUS);
            eResponse.setError(Constants.SUCCESS_MESSAGE);
            eResponse.setMessage(Constants.USER_EDIT_SUCCESS);
            return new ResponseEntity(eResponse, HttpStatus.OK);
        }
        catch (APPException e) {
            eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
            eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
            eResponse.setMessage(e.getMessage());
            return new ResponseEntity<>(eResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
            eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
            eResponse.setMessage(e.getMessage());
            return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
        public Object deleteEmployee(@PathVariable Long id){
            EmployeeGenericResponse eResponse = new EmployeeGenericResponse();
            try {
                ResponseEntity<Employees> deleteResponse = employeeService.deleteEmployees(id);
                eResponse.setStatus(Constants.SUCCESS_STATUS);
                eResponse.setError(Constants.SUCCESS_MESSAGE);
                eResponse.setMessage(Constants.USER_ARCHIVED_SUCCESS);
                return new ResponseEntity(eResponse, HttpStatus.OK);
            }
            catch (APPException e) {
                eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
                eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
                eResponse.setMessage(e.getMessage());
                return new ResponseEntity<>(eResponse, HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                eResponse.setStatus(Constants.BAD_REQUEST_STATUS);
                eResponse.setError(Constants.BAD_REQUEST_MESSAGE);
                eResponse.setMessage(e.getMessage());
                return new ResponseEntity(eResponse, HttpStatus.BAD_REQUEST);
            }


    }
}
