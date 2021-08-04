package com.spring.postgres.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeGenericResponse {
    private String status;
    private String error;
    private String message;
}

