package com.udong.entity_audit_log_annotation.api.controller;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeAddressDto;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;
import com.udong.entity_audit_log_annotation.api.service.EmployeeAddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class EmployeeAddressController {

    private final EmployeeAddressService employeeAddressService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeAddressDto> createEmployeeAddress(
            @RequestBody EmployeeAddressDto employeeAddressDto
    ) {
        log.info("===== Start Create Employee Address =====");
        EmployeeAddressDto response = employeeAddressService.create(employeeAddressDto);
        log.info("===== End Create Employee Address =====");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeAddressDto> readEmployeeAddress(
            @PathVariable BigInteger id
    ) throws DataNotFoundException {
        log.info("===== Start Read Employee Address =====");
        EmployeeAddressDto response = employeeAddressService.read(id);
        log.info("===== End Read Employee Address =====");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeAddressDto>> listEmployeeAddress() {
        log.info("===== Start List Employee Address =====");
        List<EmployeeAddressDto> response = employeeAddressService.list();
        log.info("===== End List Employee Address =====");
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<EmployeeAddressDto> updateEmployeeAddress(
            @PathVariable BigInteger id,
            @RequestBody EmployeeAddressDto employeeAddressDto
    ) throws DataNotFoundException {
        log.info("===== Start Update Employee Address =====");
        EmployeeAddressDto response = employeeAddressService.update(id, employeeAddressDto);
        log.info("===== End Update Employee Address =====");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeAddressDto> deleteEmployeeAddress(
            @PathVariable BigInteger id
    ) throws DataNotFoundException {
        log.info("===== Start Delete Employee Address =====");
        EmployeeAddressDto response = employeeAddressService.delete(id);
        log.info("===== End Delete Employee Address =====");
        return ResponseEntity.ok(response);
    }
}
