package com.example.demo.parts;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PartsService}.
 */
@Generated
public class PartsService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PartsService apply(RegisteredBean registeredBean, PartsService instance) {
    AutowiredFieldValueResolver.forRequiredField("partsrepo").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
