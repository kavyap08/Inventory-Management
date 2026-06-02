package org.springframework.ws.config.annotation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.AutowiredMethodArgumentsResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link DelegatingWsConfiguration}.
 */
@Generated
public class DelegatingWsConfiguration__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static DelegatingWsConfiguration apply(RegisteredBean registeredBean,
      DelegatingWsConfiguration instance) {
    AutowiredMethodArgumentsResolver.forRequiredMethod("setConfigurers", ObjectProvider.class).resolve(registeredBean, args -> instance.setConfigurers(args.get(0)));
    return instance;
  }
}
