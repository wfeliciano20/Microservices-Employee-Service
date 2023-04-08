package com.williamfeliciano.employeeservice.service;

import com.williamfeliciano.employeeservice.dto.DeparmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{department-code}")
    DeparmentDto getDepartment(@PathVariable("department-code") String department);
}
