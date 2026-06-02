package com.example.demo.parts;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PartsService}.
 */
@Generated
public class PartsService__BeanDefinitions {
  /**
   * Get the bean definition for 'partsService'.
   */
  public static BeanDefinition getPartsServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PartsService.class);
    InstanceSupplier<PartsService> instanceSupplier = InstanceSupplier.using(PartsService::new);
    instanceSupplier = instanceSupplier.andThen(PartsService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
