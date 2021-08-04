package com.spring.postgres.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
