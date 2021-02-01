package kimilm.bank.postprocessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import kimilm.bank.common.InstanceValidator;

public class InstanceValidationBeanPostProcessor implements BeanPostProcessor, Ordered {
	private static Logger logger = LogManager.getLogger(InstanceValidationBeanPostProcessor.class);
	private int order;
	
	public InstanceValidationBeanPostProcessor () {
		logger.info("Created InstanceValidationBeanPostProcessor instance");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("postProcessBeforeInitialization method invoked");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info("postProcessAfterInitialization method invoked");
		if (bean instanceof InstanceValidator) {
			((InstanceValidator) bean).validateInstance();
		}
		return bean;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public int getOrder() {
		return order;
	}

	
}
