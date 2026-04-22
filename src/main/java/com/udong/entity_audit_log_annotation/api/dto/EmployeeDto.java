package com.udong.entity_audit_log_annotation.api.dto;

import com.udong.entity_audit_log_annotation.api.constant.Department;
import lombok.Data;

import java.math.BigInteger;
import java.time.ZonedDateTime;

@Data
public class EmployeeDto {
    private BigInteger id;
    private String name;
    private String email;
    private Department department;
    private String salary;
    private ZonedDateTime createdDate;
}
