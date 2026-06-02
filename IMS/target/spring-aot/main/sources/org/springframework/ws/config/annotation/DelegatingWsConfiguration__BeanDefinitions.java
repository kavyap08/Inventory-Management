package org.springframework.ws.config.annotation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.ws.server.endpoint.adapter.DefaultMethodEndpointAdapter;
import org.springframework.ws.server.endpoint.mapping.PayloadRootAnnotationMethodEndpointMapping;
import org.springframework.ws.soap.addressing.server.AnnotationActionEndpointMapping;
import org.springframework.ws.soap.server.endpoint.SimpleSoapExceptionResolver;
import org.springframework.ws.soap.server.endpoint.SoapFaultAnnotationExceptionResolver;
import org.springframework.ws.soap.server.endpoint.mapping.SoapActionAnnotationMethodEndpointMapping;

/**
 * Bean definitions for {@link DelegatingWsConfiguration}.
 */
@Generated
public class DelegatingWsConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'delegatingWsConfiguration'.
   */
  public static BeanDefinition getDelegatingWsConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DelegatingWsConfiguration.class);
    beanDefinition.setTargetType(DelegatingWsConfiguration.class);
    ConfigurationClassUtils.initializeConfigurationClass(DelegatingWsConfiguration.class);
    InstanceSupplier<DelegatingWsConfiguration> instanceSupplier = InstanceSupplier.using(DelegatingWsConfiguration$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(DelegatingWsConfiguration__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'payloadRootAnnotationMethodEndpointMapping'.
   */
  private static BeanInstanceSupplier<PayloadRootAnnotationMethodEndpointMapping> getPayloadRootAnnotationMethodEndpointMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PayloadRootAnnotationMethodEndpointMapping>forFactoryMethod(DelegatingWsConfiguration$$SpringCGLIB$$0.class, "payloadRootAnnotationMethodEndpointMapping")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.ws.config.annotation.DelegatingWsConfiguration", DelegatingWsConfiguration.class).payloadRootAnnotationMethodEndpointMapping());
  }

  /**
   * Get the bean definition for 'payloadRootAnnotationMethodEndpointMapping'.
   */
  public static BeanDefinition getPayloadRootAnnotationMethodEndpointMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PayloadRootAnnotationMethodEndpointMapping.class);
    beanDefinition.setFactoryBeanName("org.springframework.ws.config.annotation.DelegatingWsConfiguration");
    beanDefinition.setInstanceSupplier(getPayloadRootAnnotationMethodEndpointMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'soapActionAnnotationMethodEndpointMapping'.
   */
  private static BeanInstanceSupplier<SoapActionAnnotationMethodEndpointMapping> getSoapActionAnnotationMethodEndpointMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SoapActionAnnotationMethodEndpointMapping>forFactoryMethod(DelegatingWsConfiguration$$SpringCGLIB$$0.class, "soapActionAnnotationMethodEndpointMapping")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.ws.config.annotation.DelegatingWsConfiguration", DelegatingWsConfiguration.class).soapActionAnnotationMethodEndpointMapping());
  }

  /**
   * Get the bean definition for 'soapActionAnnotationMethodEndpointMapping'.
   */
  public static BeanDefinition getSoapActionAnnotationMethodEndpointMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SoapActionAnnotationMethodEndpointMapping.class);
    beanDefinition.setFactoryBeanName("org.springframework.ws.config.annotation.DelegatingWsConfiguration");
    beanDefinition.setInstanceSupplier(getSoapActionAnnotationMethodEndpointMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'annotationActionEndpointMapping'.
   */
  private static BeanInstanceSupplier<AnnotationActionEndpointMapping> getAnnotationActionEndpointMappingInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AnnotationActionEndpointMapping>forFactoryMethod(DelegatingWsConfiguration$$SpringCGLIB$$0.class, "annotationActionEndpointMapping")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.ws.config.annotation.DelegatingWsConfiguration", DelegatingWsConfiguration.class).annotationActionEndpointMapping());
  }

  /**
   * Get the bean definition for 'annotationActionEndpointMapping'.
   */
  public static BeanDefinition getAnnotationActionEndpointMappingBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AnnotationActionEndpointMapping.class);
    beanDefinition.setFactoryBeanName("org.springframework.ws.config.annotation.DelegatingWsConfiguration");
    beanDefinition.setInstanceSupplier(getAnnotationActionEndpointMappingInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'defaultMethodEndpointAdapter'.
   */
  private static BeanInstanceSupplier<DefaultMethodEndpointAdapter> getDefaultMethodEndpointAdapterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DefaultMethodEndpointAdapter>forFactoryMethod(DelegatingWsConfiguration$$SpringCGLIB$$0.class, "defaultMethodEndpointAdapter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.ws.config.annotation.DelegatingWsConfiguration", DelegatingWsConfiguration.class).defaultMethodEndpointAdapter());
  }

  /**
   * Get the bean definition for 'defaultMethodEndpointAdapter'.
   */
  public static BeanDefinition getDefaultMethodEndpointAdapterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(DefaultMethodEndpointAdapter.class);
    beanDefinition.setFactoryBeanName("org.springframework.ws.config.annotation.DelegatingWsConfiguration");
    beanDefinition.setInstanceSupplier(getDefaultMethodEndpointAdapterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'soapFaultAnnotationExceptionResolver'.
   */
  private static BeanInstanceSupplier<SoapFaultAnnotationExceptionResolver> getSoapFaultAnnotationExceptionResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SoapFaultAnnotationExceptionResolver>forFactoryMethod(DelegatingWsConfiguration$$SpringCGLIB$$0.class, "soapFaultAnnotationExceptionResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.ws.config.annotation.DelegatingWsConfiguration", DelegatingWsConfiguration.class).soapFaultAnnotationExceptionResolver());
  }

  /**
   * Get the bean definition for 'soapFaultAnnotationExceptionResolver'.
   */
  public static BeanDefinition getSoapFaultAnnotationExceptionResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SoapFaultAnnotationExceptionResolver.class);
    beanDefinition.setFactoryBeanName("org.springframework.ws.config.annotation.DelegatingWsConfiguration");
    beanDefinition.setInstanceSupplier(getSoapFaultAnnotationExceptionResolverInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'simpleSoapExceptionResolver'.
   */
  private static BeanInstanceSupplier<SimpleSoapExceptionResolver> getSimpleSoapExceptionResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SimpleSoapExceptionResolver>forFactoryMethod(DelegatingWsConfiguration$$SpringCGLIB$$0.class, "simpleSoapExceptionResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.ws.config.annotation.DelegatingWsConfiguration", DelegatingWsConfiguration.class).simpleSoapExceptionResolver());
  }

  /**
   * Get the bean definition for 'simpleSoapExceptionResolver'.
   */
  public static BeanDefinition getSimpleSoapExceptionResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SimpleSoapExceptionResolver.class);
    beanDefinition.setFactoryBeanName("org.springframework.ws.config.annotation.DelegatingWsConfiguration");
    beanDefinition.setInstanceSupplier(getSimpleSoapExceptionResolverInstanceSupplier());
    return beanDefinition;
  }
}
