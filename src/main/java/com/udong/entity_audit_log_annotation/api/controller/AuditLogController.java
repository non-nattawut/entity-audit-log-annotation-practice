package com.udong.entity_audit_log_annotation.api.controller;

import com.udong.entity_audit_log_annotation.api.mapper.AuditLogMapper;
import com.udong.entity_audit_log_annotation.lib.dtos.AuditLogDto;
import com.udong.entity_audit_log_annotation.lib.entity.AuditLogEntity;
import com.udong.entity_audit_log_annotation.lib.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AuditLogController {

    private final AuditLogRepository auditLogRepository;

    private final AuditLogMapper auditLogMapper;

    @GetMapping("/audit-log/list")
    public ResponseEntity<List<AuditLogDto>> listAuditLog() {
        List<AuditLogEntity> auditLogEntities = auditLogRepository.findAll();
        List<AuditLogDto> response = auditLogMapper.toAuditLogDtos(auditLogEntities);
        return ResponseEntity.ok(response);
    }
}
