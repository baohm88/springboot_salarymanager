package com.t2404e.salarymanager.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 150, message = "Name must be 2-150 characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be >= 18")
    private Integer age;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.01", message = "Salary must be > 0")
    private Double salary;

    // hidden field khi edit
    private Long id;

    // status (1=active, 0=inactive, -1=deleted)
    private Integer status;
}
