package com.example.demo.TicketPart;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TicketPartService}.
 */
@Generated
public class TicketPartService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TicketPartService apply(RegisteredBean registeredBean, TicketPartService instance) {
    AutowiredFieldValueResolver.forRequiredField("ticketPartRepo").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("ticketRepo").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("partsRepo").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("auditService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
