package com.udong.entity_audit_log_annotation.api.entity;

import com.udong.entity_audit_log_annotation.lib.annotations.AuditLog;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "employee_address")
@AuditLog(enableLogTable = true)
public class EmployeeAddressEntity extends AuditDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "employee_id")
    private BigInteger employeeId;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private  String country;
}
