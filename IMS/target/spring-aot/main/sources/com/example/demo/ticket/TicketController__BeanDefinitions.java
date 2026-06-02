package com.example.demo.ticket;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TicketController}.
 */
@Generated
public class TicketController__BeanDefinitions {
  /**
   * Get the bean definition for 'ticketController'.
   */
  public static BeanDefinition getTicketControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TicketController.class);
    InstanceSupplier<TicketController> instanceSupplier = InstanceSupplier.using(TicketController::new);
    instanceSupplier = instanceSupplier.andThen(TicketController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
