package com.example.demo.audit;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuditService}.
 */
@Generated
public class AuditService__BeanDefinitions {
  /**
   * Get the bean definition for 'auditService'.
   */
  public static BeanDefinition getAuditServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuditService.class);
    InstanceSupplier<AuditService> instanceSupplier = InstanceSupplier.using(AuditService::new);
    instanceSupplier = instanceSupplier.andThen(AuditService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
