package com.udong.entity_audit_log_annotation.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "audit_log")
public class AuditLogEntity extends AuditDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger id;

    @Column(name = "table")
    private String table;

    @Column(name = "operator")
    private String operator; // create read update delete
}
