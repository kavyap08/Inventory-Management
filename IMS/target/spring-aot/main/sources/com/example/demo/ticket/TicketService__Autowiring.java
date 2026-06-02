package com.example.demo.ticket;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TicketService}.
 */
@Generated
public class TicketService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TicketService apply(RegisteredBean registeredBean, TicketService instance) {
    AutowiredFieldValueResolver.forRequiredField("ticrepo").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
