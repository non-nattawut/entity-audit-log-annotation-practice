package com.udong.entity_audit_log_annotation.lib.listener;

import com.udong.entity_audit_log_annotation.lib.annotations.AuditLog;
import com.udong.entity_audit_log_annotation.lib.constant.Operation;
import com.udong.entity_audit_log_annotation.lib.dtos.ConvertedJsonDataDto;
import com.udong.entity_audit_log_annotation.lib.entity.AuditLogEntity;
import com.udong.entity_audit_log_annotation.lib.repository.AuditLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class AuditLogPostDeleteEventListener extends AbstractAuditLogEventListener implements PostDeleteEventListener {
    private final AuditLogRepository auditLogRepository;

    public AuditLogPostDeleteEventListener(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void onPostDelete(PostDeleteEvent event) {
        AuditLog auditLog = this.getAuditLogAnnotation(event);

        if (auditLog == null) {
            return;
        }

        ConvertedJsonDataDto dto = convertToJson(event, event.getDeletedState());
        log.info("===== deleted data =====");
        log.info(dto.getMaskedData());

        if (auditLog.enableLogTable()) {
            log.info("Saved to audit log table");
            AuditLogEntity auditLogEntity = new AuditLogEntity();
            auditLogEntity.setOperation(Operation.DELETE);
            auditLogEntity.setTableName(event.getPersister().getTableName());
            if (auditLog.maskLogTable()) {
                auditLogEntity.setOldData(dto.getMaskedData());
            } else {
                auditLogEntity.setOldData(dto.getData());
            }

            auditLogRepository.save(auditLogEntity);
        }
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        return true;
    }
}
