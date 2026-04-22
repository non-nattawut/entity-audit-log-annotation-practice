package com.udong.entity_audit_log_annotation.api.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class EmployeeAddressDto {
    private BigInteger id;
    private BigInteger employeeId;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
