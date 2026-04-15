package com.udong.entity_audit_log_annotation.api.service;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeDto;

import java.math.BigInteger;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);
    EmployeeDto update(BigInteger id, EmployeeDto employeeDto) throws com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;
}
