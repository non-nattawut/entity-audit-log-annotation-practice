package com.udong.entity_audit_log_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EntityAuditLogAnnotationApplication {
	 private EntityAuditLogAnnotationApplication() {
		 /* This utility class should not be instantiated */
	 }

	static void main(String[] args) {
		SpringApplication.run(EntityAuditLogAnnotationApplication.class, args);
	}

}
