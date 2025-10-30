package com.t2404e.salarymanager.exception;

import com.t2404e.salarymanager.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý lỗi validation (Bad Request 400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(
                ApiResponse.<Map<String, String>>builder()
                        .success(false)
                        .message("Validation failed")
                        .data(errors)
                        .build()
        );
    }

    // Xử lý lỗi IllegalArgumentException (ví dụ trùng tên, không tìm thấy user)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(
                ApiResponse.<String>builder()
                        .success(false)
                        .message(ex.getMessage())
                        .build()
        );
    }

    // Xử lý lỗi JSON parse error (ví dụ thừa dấu phẩy hoặc sai định dạng request body)
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<String>> handleJsonParseError(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body(
                ApiResponse.<String>builder()
                        .success(false)
                        .message("JSON parse error: " + ex.getMostSpecificCause().getMessage())
                        .build()
        );
    }

    // Xử lý lỗi chung (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneralError(Exception ex) {
        return ResponseEntity.internalServerError().body(
                ApiResponse.<String>builder()
                        .success(false)
                        .message("Internal server error: " + ex.getMessage())
                        .build()
        );
    }
}
