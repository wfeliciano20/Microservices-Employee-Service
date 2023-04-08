package com.williamfeliciano.employeeservice.service;

import com.williamfeliciano.employeeservice.dto.APIResponseDto;
import com.williamfeliciano.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
