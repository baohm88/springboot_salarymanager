package com.t2404e.salarymanager.repository;

import com.t2404e.salarymanager.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByNameIgnoreCase(String name);

    // Tìm kiếm nhân viên theo tên (phân trang + chưa bị xóa)
    Page<Employee> findByNameContainingIgnoreCaseAndStatusNot(String keyword, int status, Pageable pageable);

    // Lấy toàn bộ nhân viên chưa bị xóa (phân trang)
    Page<Employee> findByStatusNot(int status, Pageable pageable);
}
