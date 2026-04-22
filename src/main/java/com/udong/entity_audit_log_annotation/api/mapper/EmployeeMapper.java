package com.udong.entity_audit_log_annotation.api.mapper;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeDto;
import com.udong.entity_audit_log_annotation.api.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {
    EmployeeDto toEmployeeDto(EmployeeEntity employeeEntity);
    EmployeeEntity toEmployeeEntity(EmployeeDto employeeDto);
    List<EmployeeDto> toEmployeeDtos(List<EmployeeEntity> employeeEntity);
    List<EmployeeEntity> toEmployeeEntities(List<EmployeeDto> employeeDtos);
}
