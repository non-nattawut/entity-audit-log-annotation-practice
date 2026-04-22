package com.udong.entity_audit_log_annotation.api.entity;

import com.udong.entity_audit_log_annotation.api.constant.Department;
import com.udong.entity_audit_log_annotation.lib.annotations.AuditLog;
import com.udong.entity_audit_log_annotation.lib.annotations.Mask;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "employee")
@AuditLog(enableLogTable = true)
public class EmployeeEntity extends AuditDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private Department department;

    @Mask
    @Column(name = "salary")
    private String salary;
}
