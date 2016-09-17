package org.camunda.bpm.spring.boot.starter.configuration.impl;

import javax.persistence.EntityManagerFactory;

import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.configuration.CamundaJpaConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultJpaConfiguration extends AbstractCamundaConfiguration implements CamundaJpaConfiguration {

  @Autowired(required = false)
  private EntityManagerFactory jpaEntityManagerFactory;

  @Override
  public void preInit(SpringProcessEngineConfiguration configuration) {
    configuration.setJpaPersistenceUnitName(springProcessEngineConfigurationTemplate.getJpaPersistenceUnitName());
    if (jpaEntityManagerFactory != null) {
      configuration.setJpaEntityManagerFactory(jpaEntityManagerFactory);
    }
    configuration.setJpaCloseEntityManager(springProcessEngineConfigurationTemplate.isJpaCloseEntityManager());
    configuration.setJpaHandleTransaction(springProcessEngineConfigurationTemplate.isJpaHandleTransaction());
  }
}