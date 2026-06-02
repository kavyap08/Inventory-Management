package com.example.demo.ticket;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TicketController}.
 */
@Generated
public class TicketController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TicketController apply(RegisteredBean registeredBean, TicketController instance) {
    instance.service = AutowiredFieldValueResolver.forRequiredField("service").resolve(registeredBean);
    instance.userservice = AutowiredFieldValueResolver.forRequiredField("userservice").resolve(registeredBean);
    AutowiredFieldValueResolver.forRequiredField("auditService").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("ticketPartService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
