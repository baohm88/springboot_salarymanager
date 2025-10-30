package com.t2404e.salarymanager.service;

import com.t2404e.salarymanager.entity.Employee;
import com.t2404e.salarymanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    // Lấy danh sách phân trang + tìm kiếm
    public Page<Employee> getAllPaged(int page, int size, String keyword) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("id").ascending());

        if (keyword != null && !keyword.isBlank()) {
            return repo.findByNameContainingIgnoreCaseAndStatusNot(keyword, -1, pageable);
        }

        return repo.findByStatusNot(-1, pageable);
    }

    // Lấy toàn bộ nhân viên active (không phân trang)
    public java.util.List<Employee> getAllActive() {
        return repo.findByStatusNot(-1, Pageable.unpaged()).getContent();
    }

    // Lấy chi tiết nhân viên theo ID
    public Employee get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with id " + id));
    }

    // Tạo mới nhân viên
    public Employee create(Employee emp) {
        if (repo.existsByNameIgnoreCase(emp.getName())) {
            throw new IllegalArgumentException("Employee with name '" + emp.getName() + "' already exists!");
        }
        emp.setStatus(1); // active mặc định
        return repo.save(emp);
    }

    // Cập nhật thông tin nhân viên
    public Employee update(Long id, Employee emp) {
        Employee existing = get(id);

        if (repo.existsByNameIgnoreCase(emp.getName())
                && !existing.getName().equalsIgnoreCase(emp.getName())) {
            throw new IllegalArgumentException("Employee with name '" + emp.getName() + "' already exists!");
        }

        existing.setName(emp.getName());
        existing.setAge(emp.getAge());
        existing.setSalary(emp.getSalary());
        existing.setStatus(emp.getStatus() != null ? emp.getStatus() : existing.getStatus());

        return repo.save(existing);
    }

    // Xóa mềm nhân viên (status = -1)
    public void delete(Long id) {
        Employee existing = get(id);
        existing.setStatus(-1);
        repo.save(existing);
    }
}
