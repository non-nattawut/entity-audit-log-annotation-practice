package com.udong.entity_audit_log_annotation.api.service;

import com.udong.entity_audit_log_annotation.api.constant.Department;
import com.udong.entity_audit_log_annotation.api.dto.EmployeeDto;
import com.udong.entity_audit_log_annotation.api.entity.EmployeeEntity;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;
import com.udong.entity_audit_log_annotation.api.mapper.EmployeeMapper;
import com.udong.entity_audit_log_annotation.api.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Transactional(rollbackFor = Exception.class)
    public EmployeeDto create(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employeeDto);
        EmployeeEntity result = employeeRepository.save(employeeEntity);
        return employeeMapper.toEmployeeDto(result);
    }

    @Transactional(rollbackFor = Exception.class)
    public EmployeeDto read(BigInteger id) throws DataNotFoundException {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Employee not found"));

        return employeeMapper.toEmployeeDto(employeeEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<EmployeeDto> list() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeMapper.toEmployeeDtos(employeeEntities);
    }

    @Transactional(rollbackFor = Exception.class)
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

        String salary = employeeDto.getSalary();
        if (StringUtils.hasText(salary)) {
            employeeEntity.setSalary(salary);
        }

        EmployeeEntity result = employeeRepository.save(employeeEntity);
        return employeeMapper.toEmployeeDto(result);
    }

    @Transactional(rollbackFor = Exception.class)
    public EmployeeDto delete(BigInteger id) throws DataNotFoundException {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Employee not found"));

        employeeRepository.delete(employeeEntity);
        return employeeMapper.toEmployeeDto(employeeEntity);
    }
}
