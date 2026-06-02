package com.example.demo;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link HomeController}.
 */
@Generated
public class HomeController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static HomeController apply(RegisteredBean registeredBean, HomeController instance) {
    AutowiredFieldValueResolver.forRequiredField("homeRepo").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("ticketservice").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("partsservice").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
