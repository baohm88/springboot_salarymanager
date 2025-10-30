package com.t2404e.salarymanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T> {
    private List<T> data;
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private long totalElements;
}
