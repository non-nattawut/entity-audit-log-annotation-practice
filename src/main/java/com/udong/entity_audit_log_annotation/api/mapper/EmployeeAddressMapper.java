package com.udong.entity_audit_log_annotation.api.mapper;

import com.udong.entity_audit_log_annotation.api.dto.EmployeeAddressDto;
import com.udong.entity_audit_log_annotation.api.entity.EmployeeAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeAddressMapper {
    EmployeeAddressDto toEmployeeAddressDto(EmployeeAddressEntity employeeAddressEntity);
    EmployeeAddressEntity toEmployeeAddressEntity(EmployeeAddressDto employeeAddressDto);
    List<EmployeeAddressDto> toEmployeeAddressDtos(List<EmployeeAddressEntity> employeeAddressEntities);
    List<EmployeeAddressEntity> toEmployeeAddressEntities(List<EmployeeAddressDto> employeeAddressDtos);
}
