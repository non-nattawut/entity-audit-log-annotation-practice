package com.udong.entity_audit_log_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EntityAuditLogAnnotationApplication {
	 private EntityAuditLogAnnotationApplication() {
		 /* This utility class should not be instantiated */
	 }

	static void main(String[] args) {
		SpringApplication.run(EntityAuditLogAnnotationApplication.class, args);
	}

}
