package com.example.demo.TicketPart;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TicketPartService}.
 */
@Generated
public class TicketPartService__BeanDefinitions {
  /**
   * Get the bean definition for 'ticketPartService'.
   */
  public static BeanDefinition getTicketPartServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TicketPartService.class);
    InstanceSupplier<TicketPartService> instanceSupplier = InstanceSupplier.using(TicketPartService::new);
    instanceSupplier = instanceSupplier.andThen(TicketPartService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
