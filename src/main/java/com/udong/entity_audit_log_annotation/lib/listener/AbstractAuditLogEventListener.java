package com.udong.entity_audit_log_annotation.lib.listener;

import com.udong.entity_audit_log_annotation.lib.annotations.AuditLog;
import com.udong.entity_audit_log_annotation.lib.annotations.Mask;
import com.udong.entity_audit_log_annotation.lib.dtos.ConvertedJsonDataDto;
import com.udong.entity_audit_log_annotation.lib.helper.MaskDataUtil;
import org.hibernate.event.spi.AbstractPostDatabaseOperationEvent;
import org.hibernate.persister.entity.EntityPersister;
import tools.jackson.databind.ObjectMapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AbstractAuditLogEventListener {
    private final ObjectMapper objectMapper = new ObjectMapper();

    ConvertedJsonDataDto convertToJson(AbstractPostDatabaseOperationEvent event, Object[] state){
        EntityPersister persister = event.getPersister();
        Field[] fields = event.getEntity().getClass().getDeclaredFields();

        Map<String, Object> data = convertStateToMap(persister, state);
        Map<String, Object> maskedData = mask(persister, fields, data);

        String dataJson = convertMapToJson(data);
        String maskedDataJson = convertMapToJson(maskedData);

        return new ConvertedJsonDataDto(dataJson, maskedDataJson);
    }

    private String convertMapToJson(Map<String, Object> data) {
        return objectMapper.writeValueAsString(data);
    }

    private Map<String, Object> convertStateToMap(EntityPersister persister, Object[] state) {
        Map<String, Object> data = new HashMap<>();

        for (String name : persister.getPropertyNames()) {
            data.put(name, state[persister.getPropertyIndex(name)]);
        }

        return data;
    }

    private Map<String, Object> mask(EntityPersister persister, Field[] fields, Map<String, Object> data) {
        Map<String, Object> newData = new HashMap<>(data);

        for (String name : persister.getPropertyNames()) {
            Mask mask = fields[persister.getPropertyIndex(name)].getAnnotation(Mask.class);
            if (mask != null) {
                newData.put(name, MaskDataUtil.getMaskedField(mask));
            }
        }

        return newData;
    }

    AuditLog getAuditLogAnnotation(AbstractPostDatabaseOperationEvent event) {
        return event.getEntity().getClass().getAnnotation(AuditLog.class);
    }
}
