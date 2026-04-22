package com.udong.entity_audit_log_annotation.lib.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConvertedJsonDataDto {
    private String data;
    private String maskedData;
}
