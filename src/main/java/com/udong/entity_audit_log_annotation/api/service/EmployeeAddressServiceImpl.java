package com.udong.entity_audit_log_annotation.api.service;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeAddressDto;
import com.udong.entity_audit_log_annotation.api.entity.EmployeeAddressEntity;
import com.udong.entity_audit_log_annotation.api.exception.DataNotFoundException;
import com.udong.entity_audit_log_annotation.api.mapper.EmployeeAddressMapper;
import com.udong.entity_audit_log_annotation.api.repository.EmployeeAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private final EmployeeAddressRepository employeeAddressRepository;
    private final EmployeeAddressMapper employeeAddressMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAddressDto create(EmployeeAddressDto employeeAddressDto) {
        EmployeeAddressEntity entity = employeeAddressMapper.toEmployeeAddressEntity(employeeAddressDto);
        EmployeeAddressEntity result = employeeAddressRepository.save(entity);
        return employeeAddressMapper.toEmployeeAddressDto(result);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAddressDto read(BigInteger id) throws DataNotFoundException {
        EmployeeAddressEntity entity = employeeAddressRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Employee address not found"));
        return employeeAddressMapper.toEmployeeAddressDto(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<EmployeeAddressDto> list() {
        List<EmployeeAddressEntity> entities = employeeAddressRepository.findAll();
        return employeeAddressMapper.toEmployeeAddressDtos(entities);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAddressDto update(BigInteger id, EmployeeAddressDto employeeAddressDto) throws DataNotFoundException {
        EmployeeAddressEntity entity = employeeAddressRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Employee address not found"));

        if (employeeAddressDto.getEmployeeId() != null) {
            entity.setEmployeeId(employeeAddressDto.getEmployeeId());
        }
        if (employeeAddressDto.getStreet() != null) {
            entity.setStreet(employeeAddressDto.getStreet());
        }
        if (employeeAddressDto.getCity() != null) {
            entity.setCity(employeeAddressDto.getCity());
        }
        if (employeeAddressDto.getState() != null) {
            entity.setState(employeeAddressDto.getState());
        }
        if (employeeAddressDto.getZipCode() != null) {
            entity.setZipCode(employeeAddressDto.getZipCode());
        }
        if (employeeAddressDto.getCountry() != null) {
            entity.setCountry(employeeAddressDto.getCountry());
        }

        EmployeeAddressEntity result = employeeAddressRepository.save(entity);
        return employeeAddressMapper.toEmployeeAddressDto(result);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeAddressDto delete(BigInteger id) throws DataNotFoundException {
        EmployeeAddressEntity entity = employeeAddressRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Employee address not found"));
        employeeAddressRepository.delete(entity);
        return employeeAddressMapper.toEmployeeAddressDto(entity);
    }
}
