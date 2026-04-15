package com.udong.entity_audit_log_annotation.api.dto;

import com.udong.entity_audit_log_annotation.api.constant.Department;
import lombok.Data;

import java.math.BigInteger;

@Data
public class EmployeeDto {
    private BigInteger id;
    private String name;
    private String email;
    private Department department;
}
