package com.example.demo.audit;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AuditController}.
 */
@Generated
public class AuditController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AuditController apply(RegisteredBean registeredBean, AuditController instance) {
    AutowiredFieldValueResolver.forRequiredField("auditservice").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("ticketservice").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("partsservice").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("ticketpartservice").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
