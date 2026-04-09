package com.udong.entity_audit_log_annotation.api.entity;

import com.udong.entity_audit_log_annotation.api.constant.Department;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "employee")
public class EmployeeEntity extends AuditDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private java.math.BigInteger id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private Department department;
}
