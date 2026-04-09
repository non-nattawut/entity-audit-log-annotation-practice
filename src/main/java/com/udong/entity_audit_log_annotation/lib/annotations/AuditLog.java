package com.udong.entity_audit_log_annotation.lib.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuditLog {
    String savedToTable() default "audit_log";
}
