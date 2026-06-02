package com.example.demo.parts;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PartsController}.
 */
@Generated
public class PartsController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PartsController apply(RegisteredBean registeredBean, PartsController instance) {
    AutowiredFieldValueResolver.forRequiredField("partsservice").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
