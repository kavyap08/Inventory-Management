package com.example.demo.audit;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AuditService}.
 */
@Generated
public class AuditService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AuditService apply(RegisteredBean registeredBean, AuditService instance) {
    AutowiredFieldValueResolver.forRequiredField("userrepo").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("ticketrepo").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("auditrepo").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
