package com.udong.entity_audit_log_annotation.api.controller;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeDto;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;
import com.udong.entity_audit_log_annotation.api.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController()
@RequiredArgsConstructor
public class MainController {

    private final EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public String createEmployee() {
        return "test";
    }

    @GetMapping("/get/{id}")
    public String readEmployee() {
        return "test";
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable BigInteger id,
            @RequestBody EmployeeDto employeeDto
    ) throws DataNotFoundException {
        EmployeeDto response = employeeService.update(id, employeeDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete")
    public String deleteEmployee() {
        return "test";
    }
}
