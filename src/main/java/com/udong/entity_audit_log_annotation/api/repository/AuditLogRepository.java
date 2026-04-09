package com.udong.entity_audit_log_annotation.api.repository;

import com.udong.entity_audit_log_annotation.api.entity.AuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLogEntity, BigInteger> {
}
