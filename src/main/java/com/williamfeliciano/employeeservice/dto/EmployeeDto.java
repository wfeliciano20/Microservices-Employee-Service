package com.williamfeliciano.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "EmployeeDto Model Documentation"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    @Schema(
            description = "Employee's First Name"
    )
    @NotEmpty
    private String firstName;
    @Schema(
            description = "Employee's Last Name'"
    )
    @NotEmpty
    private String lastName;
    @Schema(
            description = "Employee's Email"
    )
    @NotEmpty
    @Email
    private String email;
    @Schema(
            description = "Employee's DepartmentCode"
    )
    private String deparmentCode;
    @Schema(
            description = "Employee's OrganizationCode"
    )
    private String organizationCode;

}
