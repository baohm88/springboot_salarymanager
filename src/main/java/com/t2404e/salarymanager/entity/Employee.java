package com.t2404e.salarymanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employees", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 150, message = "Name must be 2-150 characters")
    @Column(nullable = false, length = 150)
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be >= 18")
    @Column(nullable = false)
    private Integer age;

    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.01", message = "Salary must be > 0")
    @Column(nullable = false)
    private Double salary;

    // Trạng thái: 1 = active, 0 = inactive, -1 = deleted
    @Column(nullable = false, columnDefinition = "INT DEFAULT 1")
    private Integer status = 1;

    // Tự động ghi ngày tạo
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Tự động ghi ngày sửa
    @UpdateTimestamp
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;
}
