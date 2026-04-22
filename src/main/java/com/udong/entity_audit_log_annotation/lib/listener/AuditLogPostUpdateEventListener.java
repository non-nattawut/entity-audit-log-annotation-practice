package com.udong.entity_audit_log_annotation.lib.listener;

import com.udong.entity_audit_log_annotation.lib.annotations.AuditLog;
import com.udong.entity_audit_log_annotation.lib.constant.Operation;
import com.udong.entity_audit_log_annotation.lib.dtos.ConvertedJsonDataDto;
import com.udong.entity_audit_log_annotation.lib.entity.AuditLogEntity;
import com.udong.entity_audit_log_annotation.lib.repository.AuditLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class AuditLogPostUpdateEventListener extends AbstractAuditLogEventListener implements PostUpdateEventListener {
    private final AuditLogRepository auditLogRepository;

    public AuditLogPostUpdateEventListener(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Override
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void onPostUpdate(PostUpdateEvent event) {
        AuditLog auditLog = this.getAuditLogAnnotation(event);

        if (auditLog == null) {
            return;
        }

        ConvertedJsonDataDto oldDataDto = convertToJson(event, event.getOldState());
        ConvertedJsonDataDto newDataDto = convertToJson(event, event.getState());

        log.info("===== Old Data =====");
        log.info(oldDataDto.getMaskedData());
        log.info("===== New Data =====");
        log.info(newDataDto.getMaskedData());

        if (auditLog.enableLogTable()) {
            log.info("Saved to audit log table");
            AuditLogEntity auditLogEntity = new AuditLogEntity();
            auditLogEntity.setOperation(Operation.UPDATE);
            auditLogEntity.setTableName(event.getPersister().getTableName());
            if (auditLog.maskLogTable()) {
                auditLogEntity.setOldData(oldDataDto.getMaskedData());
                auditLogEntity.setNewData(newDataDto.getMaskedData());
            } else {
                auditLogEntity.setOldData(oldDataDto.getData());
                auditLogEntity.setNewData(newDataDto.getData());
            }

            auditLogRepository.save(auditLogEntity);
        }
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        return true;
    }
}
