package com.udong.entity_audit_log_annotation.api.service;

import com.udong.entity_audit_log_annotation.api.constant.Department;
import com.udong.entity_audit_log_annotation.api.dto.EmployeeDto;
import com.udong.entity_audit_log_annotation.api.entity.EmployeeEntity;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;
import com.udong.entity_audit_log_annotation.api.mapper.EmployeeMapper;
import com.udong.entity_audit_log_annotation.api.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeDto create(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employeeDto);
        EmployeeEntity result = employeeRepository.save(employeeEntity);
        return employeeMapper.toEmployeeDto(result);
    }

    public EmployeeDto update(BigInteger id, EmployeeDto employeeDto) throws DataNotFoundException {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Employee not found"));

        String name = employeeDto.getName();
        if (name != null) {
            employeeEntity.setName(name);
        }

        String email = employeeDto.getEmail();
        if (email != null) {
            employeeEntity.setEmail(email);
        }

        Department department = employeeDto.getDepartment();
        if (department != null) {
            employeeEntity.setDepartment(department);
        }

        EmployeeEntity result = employeeRepository.save(employeeEntity);
        return employeeMapper.toEmployeeDto(result);
    }
}
