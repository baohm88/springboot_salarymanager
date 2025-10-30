package com.t2404e.salarymanager.controller;

import com.t2404e.salarymanager.dto.ApiResponse;
import com.t2404e.salarymanager.dto.PageResponse;
import com.t2404e.salarymanager.entity.Employee;
import com.t2404e.salarymanager.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // 1. Lấy danh sách nhân viên (có phân trang + tìm kiếm)
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<Employee>>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) String q
    ) {
        var pageResult = service.getAllPaged(page, size, q);

        PageResponse<Employee> pageResponse = PageResponse.<Employee>builder()
                .data(pageResult.getContent())
                .currentPage(page)
                .pageSize(size)
                .totalPages(pageResult.getTotalPages())
                .totalElements(pageResult.getTotalElements())
                .build();

        return ResponseEntity.ok(
                ApiResponse.<PageResponse<Employee>>builder()
                        .success(true)
                        .message("Fetched employees successfully")
                        .data(pageResponse)
                        .build()
        );
    }

    // 2. Lấy chi tiết nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getById(@PathVariable Long id) {
        Employee emp = service.get(id);
        return ResponseEntity.ok(
                ApiResponse.<Employee>builder()
                        .success(true)
                        .message("Fetched employee successfully")
                        .data(emp)
                        .build()
        );
    }

    // 3. Tạo mới nhân viên
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> create(@Valid @RequestBody Employee emp) {
        Employee saved = service.create(emp);
        return ResponseEntity.ok(
                ApiResponse.<Employee>builder()
                        .success(true)
                        .message("Employee created successfully")
                        .data(saved)
                        .build()
        );
    }

    // 4. Cập nhật nhân viên
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> update(@PathVariable Long id, @Valid @RequestBody Employee emp) {
        Employee updated = service.update(id, emp);
        return ResponseEntity.ok(
                ApiResponse.<Employee>builder()
                        .success(true)
                        .message("Employee updated successfully")
                        .data(updated)
                        .build()
        );
    }

    // 5. Xóa mềm nhân viên (status = -1)
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Employee deleted (soft delete applied)")
                        .build()
        );
    }
}
