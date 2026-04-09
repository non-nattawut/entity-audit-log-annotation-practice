package com.udong.entity_audit_log_annotation.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public class AuditDateEntity {
    @CreationTimestamp
    @Column(name = "created_date")
    private ZonedDateTime createdDate;
}
