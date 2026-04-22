package com.udong.entity_audit_log_annotation.lib.dtos;

import com.udong.entity_audit_log_annotation.lib.constant.Operation;
import lombok.Data;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@Data
public class AuditLogDto {
    private BigInteger id;
    private String tableName;
    private Operation operation;
    private String oldData;
    private String newData;
    private ZonedDateTime createdDate;
}
