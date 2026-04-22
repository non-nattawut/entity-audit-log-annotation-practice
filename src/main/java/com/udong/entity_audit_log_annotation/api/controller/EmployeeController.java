package com.udong.entity_audit_log_annotation.api.controller;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeDto;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;
import com.udong.entity_audit_log_annotation.api.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(
            @RequestBody EmployeeDto employeeDto
    ) {
        log.info("===== Start Create Employee =====");

        EmployeeDto response = employeeService.create(employeeDto);

        log.info("===== End Create Employee =====");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeDto> readEmployee(
        @PathVariable BigInteger id
    ) throws DataNotFoundException {
        log.info("===== Start Read Employee =====");

        EmployeeDto response = employeeService.read(id);

        log.info("===== End Read Employee =====");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDto>> listEmployee() {
        log.info("===== Start List Employee =====");

        List<EmployeeDto> response = employeeService.list();

        log.info("===== End List Employee =====");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable BigInteger id,
            @RequestBody EmployeeDto employeeDto
    ) throws DataNotFoundException {
        log.info("===== Start Update Employee =====");

        EmployeeDto response = employeeService.update(id, employeeDto);

        log.info("===== End Update Employee =====");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(
            @PathVariable BigInteger id
    ) throws DataNotFoundException {
        log.info("===== Start Delete Employee =====");

        EmployeeDto response = employeeService.delete(id);

        log.info("===== End Delete Employee =====");
        return ResponseEntity.ok(response);
    }
}
