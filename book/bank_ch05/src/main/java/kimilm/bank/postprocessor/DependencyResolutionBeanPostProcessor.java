package kimilm.bank.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import kimilm.bank.common.InstanceValidator;
import kimilm.bank.common.MyApplicationContext;

public class DependencyResolutionBeanPostProcessor implements BeanPostProcessor, Ordered {

	private MyApplicationContext myApplicationContext;
	private int order;
	
	public void setMyApplicationContext(MyApplicationContext myApplicationContext) {
		this.myApplicationContext = myApplicationContext;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public int getOrder() {
		return order;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof InstanceValidator) {
			((InstanceValidator) bean).validateInstance();
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
	
}
