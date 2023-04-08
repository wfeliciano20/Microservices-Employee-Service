package com.williamfeliciano.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIResponseDto {

    private EmployeeDto employee;
    private DeparmentDto deparment;
}
