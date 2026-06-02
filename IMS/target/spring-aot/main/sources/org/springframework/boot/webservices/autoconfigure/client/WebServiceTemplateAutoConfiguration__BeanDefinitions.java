package org.springframework.boot.webservices.autoconfigure.client;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.webservices.client.WebServiceMessageSenderFactory;
import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;

/**
 * Bean definitions for {@link WebServiceTemplateAutoConfiguration}.
 */
@Generated
public class WebServiceTemplateAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'webServiceTemplateAutoConfiguration'.
   */
  public static BeanDefinition getWebServiceTemplateAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebServiceTemplateAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(WebServiceTemplateAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webServiceHttpMessageSenderFactory'.
   */
  private static BeanInstanceSupplier<WebServiceMessageSenderFactory> getWebServiceHttpMessageSenderFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebServiceMessageSenderFactory>forFactoryMethod(WebServiceTemplateAutoConfiguration.class, "webServiceHttpMessageSenderFactory", ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webservices.autoconfigure.client.WebServiceTemplateAutoConfiguration", WebServiceTemplateAutoConfiguration.class).webServiceHttpMessageSenderFactory(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'webServiceHttpMessageSenderFactory'.
   */
  public static BeanDefinition getWebServiceHttpMessageSenderFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebServiceMessageSenderFactory.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webservices.autoconfigure.client.WebServiceTemplateAutoConfiguration");
    beanDefinition.setInstanceSupplier(getWebServiceHttpMessageSenderFactoryInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'webServiceTemplateBuilder'.
   */
  private static BeanInstanceSupplier<WebServiceTemplateBuilder> getWebServiceTemplateBuilderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<WebServiceTemplateBuilder>forFactoryMethod(WebServiceTemplateAutoConfiguration.class, "webServiceTemplateBuilder", ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.webservices.autoconfigure.client.WebServiceTemplateAutoConfiguration", WebServiceTemplateAutoConfiguration.class).webServiceTemplateBuilder(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'webServiceTemplateBuilder'.
   */
  public static BeanDefinition getWebServiceTemplateBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebServiceTemplateBuilder.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.webservices.autoconfigure.client.WebServiceTemplateAutoConfiguration");
    beanDefinition.setInstanceSupplier(getWebServiceTemplateBuilderInstanceSupplier());
    return beanDefinition;
  }
}
