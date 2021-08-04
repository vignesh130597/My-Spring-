package com.spring.postgres.dto;

import com.spring.postgres.modal.Employees;
import com.spring.postgres.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidation {

    @Autowired
    EmployeeRepository employeeRepository;

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean nameValidation(String name) {
        Pattern my_pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher my_match = my_pattern.matcher(name);
        boolean check = my_match.find();
        return check;
    }

    public String employeeValidation(EmployeeRequest employeeRequest){
        List<String> msgList = new ArrayList<>();
        if(employeeRequest.getFirstName() == null || employeeRequest.getFirstName().trim().isEmpty()){
            msgList.add(ValidationConstant.FIRSTNAME_CANNOT_BE_NULL);
        }
        else {
            if (nameValidation(employeeRequest.getFirstName())) {
                msgList.add(ValidationConstant.FIRST_SPL);
            }
        }
        if (employeeRequest.getLastName() == null || employeeRequest.getLastName().trim().isEmpty()) {
            msgList.add(ValidationConstant.LASTNAME_CANNOT_BE_NULL);
        } else {
            if (nameValidation(employeeRequest.getLastName())) {
                msgList.add(ValidationConstant.LAST_SPL);

            }
        }
        if (employeeRequest.getEmail() == null || employeeRequest.getEmail().trim().isEmpty()) {
            msgList.add(ValidationConstant.EMAIL_ADDRESS_CANNOT_BE_NULL);
        } else {
            if (!isValid(employeeRequest.getEmail()))
                msgList.add(ValidationConstant.INVALID_EMAIL);
            else {
                Employees employees = employeeRepository.findByEmail(employeeRequest.getEmail());
                if (employees != null) {
                    msgList.add(ValidationConstant.EMAIL_ADDRESS_ALREADY_EXIT);
                }

            }
        }
        String msg = MessageWrapper.finalMessage(msgList);
        return msg;
    }

    public String employeeValidationForUpdate(Long id, EmployeeRequest employeeRequest){
        List<String> msgList = new ArrayList<>();

        if (employeeRequest.getId() == null) {
            msgList.add(ValidationConstant.ID_NOT_NULL);
        } else {
            if (!id.equals(employeeRequest.getId()))
                msgList.add(ValidationConstant.ID_MIS_MATCH);
        }
        if (employeeRequest.getFirstName() == null || employeeRequest.getFirstName().trim().isEmpty()) {
            msgList.add(ValidationConstant.FIRSTNAME_CANNOT_BE_NULL);
        } else {
            if (nameValidation(employeeRequest.getFirstName())) {
                msgList.add(ValidationConstant.FIRST_SPL);
            }
        }

        if (employeeRequest.getLastName() == null || employeeRequest.getLastName().trim().isEmpty()) {
            msgList.add(ValidationConstant.LASTNAME_CANNOT_BE_NULL);
        } else {
            if (nameValidation(employeeRequest.getLastName())) {
                msgList.add(ValidationConstant.LAST_SPL);
            }
        }
        String msg = MessageWrapper.finalMessage(msgList);
        return msg;
    }
}
