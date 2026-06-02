package com.example.demo.parts;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PartsController}.
 */
@Generated
public class PartsController__BeanDefinitions {
  /**
   * Get the bean definition for 'partsController'.
   */
  public static BeanDefinition getPartsControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PartsController.class);
    InstanceSupplier<PartsController> instanceSupplier = InstanceSupplier.using(PartsController::new);
    instanceSupplier = instanceSupplier.andThen(PartsController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
