package com.udong.entity_audit_log_annotation.api.service;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeDto;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);
    EmployeeDto read(BigInteger id) throws DataNotFoundException;
    List<EmployeeDto> list();
    EmployeeDto update(BigInteger id, EmployeeDto employeeDto) throws DataNotFoundException;
    EmployeeDto delete(BigInteger id) throws DataNotFoundException;
}
