package com.udong.entity_audit_log_annotation.lib.listener;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.springframework.stereotype.Component;

@Component
public class HibernateListenerRegistration {
    private final EntityManagerFactory entityManagerFactory;
    private final AuditLogPostInsertEventListener auditLogPostInsertEventListener;
    private final AuditLogPostUpdateEventListener auditLogPostUpdateEventListener;
    private final AuditLogPostDeleteEventListener auditLogPostDeleteEventListener;

    public HibernateListenerRegistration(EntityManagerFactory entityManagerFactory,
                                         AuditLogPostInsertEventListener insertEventListener,
                                         AuditLogPostUpdateEventListener updateEventListener,
                                         AuditLogPostDeleteEventListener deleteEventListener
                                         ){
        this.entityManagerFactory = entityManagerFactory;
        this.auditLogPostInsertEventListener = insertEventListener;
        this.auditLogPostUpdateEventListener = updateEventListener;
        this.auditLogPostDeleteEventListener = deleteEventListener;
    }

    @PostConstruct
    void registerListeners() {
        // Unwrap the Hibernate Session Factory from JPA
        SessionFactoryImplementor sessionFactory = entityManagerFactory.unwrap(SessionFactoryImplementor.class);

        // Get the Hibernate Event Registry
        EventListenerRegistry registry = sessionFactory
                .getServiceRegistry()
                .getService(EventListenerRegistry.class);

        // Append custom listener to event group
        if (registry != null) {
            registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(auditLogPostInsertEventListener);
            registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(auditLogPostUpdateEventListener);
            registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(auditLogPostDeleteEventListener);
        }
    }
}
