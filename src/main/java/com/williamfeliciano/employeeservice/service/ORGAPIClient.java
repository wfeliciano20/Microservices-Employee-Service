package com.williamfeliciano.employeeservice.service;

import com.williamfeliciano.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8083", name = "ORGANIZATION-SERVICE")
public interface ORGAPIClient {
    @GetMapping("api/organizations/{organization-code}")
    OrganizationDto getOrganization(@PathVariable("organization-code") String organizationCode);
}
