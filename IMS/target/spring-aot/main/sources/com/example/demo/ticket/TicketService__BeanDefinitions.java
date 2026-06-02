package com.example.demo.ticket;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TicketService}.
 */
@Generated
public class TicketService__BeanDefinitions {
  /**
   * Get the bean definition for 'ticketService'.
   */
  public static BeanDefinition getTicketServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TicketService.class);
    InstanceSupplier<TicketService> instanceSupplier = InstanceSupplier.using(TicketService::new);
    instanceSupplier = instanceSupplier.andThen(TicketService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
