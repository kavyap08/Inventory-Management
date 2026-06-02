package com.example.demo;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ImsApplication}.
 */
@Generated
public class ImsApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'imsApplication'.
   */
  public static BeanDefinition getImsApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ImsApplication.class);
    beanDefinition.setInstanceSupplier(ImsApplication::new);
    return beanDefinition;
  }
}
