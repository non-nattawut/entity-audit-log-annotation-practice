package com.udong.entity_audit_log_annotation.api.service;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeAddressDto;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;

import java.math.BigInteger;
import java.util.List;

public interface EmployeeAddressService {
    EmployeeAddressDto create(EmployeeAddressDto employeeAddressDto);
    EmployeeAddressDto read(BigInteger id) throws DataNotFoundException;
    List<EmployeeAddressDto> list();
    EmployeeAddressDto update(BigInteger id, EmployeeAddressDto employeeAddressDto) throws DataNotFoundException;
    EmployeeAddressDto delete(BigInteger id) throws DataNotFoundException;
}
