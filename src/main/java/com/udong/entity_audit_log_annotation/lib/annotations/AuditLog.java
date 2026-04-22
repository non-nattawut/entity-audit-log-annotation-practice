package com.udong.entity_audit_log_annotation.lib.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuditLog {
    boolean enableLogTable() default false;
    boolean maskLogTable() default false;
}
