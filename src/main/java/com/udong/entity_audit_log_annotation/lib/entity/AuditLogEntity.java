package com.udong.entity_audit_log_annotation.lib.entity;

import com.udong.entity_audit_log_annotation.lib.constant.Operation;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@Data
@Entity(name = "audit_log")
public class AuditLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "operation")
    @Enumerated(EnumType.STRING)
    private Operation operation;

    @Column(name = "old_data")
    private String oldData;

    @Column(name = "new_data")
    private String newData;

    @CreationTimestamp
    @Column(name = "created_date")
    private ZonedDateTime createdDate;
}
