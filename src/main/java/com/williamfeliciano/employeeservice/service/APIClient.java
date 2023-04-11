package com.williamfeliciano.employeeservice.service;

import com.williamfeliciano.employeeservice.dto.DeparmentDto;
import com.williamfeliciano.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// Manual way of connecting to other services
//@FeignClient(url="http://localhost:8080", value = "DEPARTMENT-SERVICE")
// eureka automation to connect to other services
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DeparmentDto getDepartment(@PathVariable("department-code") String department);
}


