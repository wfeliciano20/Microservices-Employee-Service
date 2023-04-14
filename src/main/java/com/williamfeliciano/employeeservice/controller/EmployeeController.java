package com.williamfeliciano.employeeservice.controller;

import com.williamfeliciano.employeeservice.dto.APIResponseDto;
import com.williamfeliciano.employeeservice.dto.EmployeeDto;
import com.williamfeliciano.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - EmployeeController",
        description = "Employee Controller Exposes REST APIs for Employee Service"
)
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary = "Save Employee REST API Endpoint",
            description = "Save Employee Object In Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status code 201 Created"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto employee =  employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get a Employee by code REST API Endpoint",
            description = "Get a Employee Object from Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status code 200 Success"
    )
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id")Long id){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
