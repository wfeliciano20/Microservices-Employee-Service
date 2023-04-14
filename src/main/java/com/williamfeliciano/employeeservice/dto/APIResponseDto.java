package com.williamfeliciano.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "APIResponseDto Model Documentation"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIResponseDto {

    @Schema(
            description = "Employee Object"
    )
    private EmployeeDto employee;
    @Schema(
            description = "Employee's Department Object"
    )
    private DeparmentDto department;
    @Schema(
            description = "Employee's Organization Object"
    )
    private OrganizationDto organization;
}
