package com.udong.entity_audit_log_annotation.api.mapper;

import com.udong.entity_audit_log_annotation.lib.dtos.AuditLogDto;
import com.udong.entity_audit_log_annotation.lib.entity.AuditLogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AuditLogMapper {
    AuditLogDto toAuditLogDto(AuditLogEntity auditLogEntity);
    List<AuditLogDto> toAuditLogDtos(List<AuditLogEntity> auditLogEntities);
}
