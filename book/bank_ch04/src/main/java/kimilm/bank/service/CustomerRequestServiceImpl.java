package kimilm.bank.service;

import java.beans.ConstructorProperties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import kimilm.bank.dao.CustomerRequestDao;
import kimilm.bank.domain.CustomerRequestDetails;

// public abstract class CustomerRequestServiceImpl implements CustomerRequestService, ApplicationContextAware {
public class CustomerRequestServiceImpl implements CustomerRequestService, ApplicationContextAware {
	private static Logger logger = LogManager
			.getLogger(CustomerRequestServiceImpl.class);
	private CustomerRequestDao customerRequestDao;
	private ApplicationContext applicationContext;

	@ConstructorProperties({ "customerRequestDao" })
	public CustomerRequestServiceImpl(
			CustomerRequestDao customerRequestDao) {
		logger.info("Created CustomerRequestServiceContextAwareImpl instance");
		this.customerRequestDao = customerRequestDao;
	}
	
	// public abstract CustomerRequestDetails getCustomerRequestDetails();
	
	public Object getMyBean(String beanName) {
		return null;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void submitRequest(String requestType, String requestDescription) {
		// -- populate CustomerRequestDetails object and save it
		// CustomerRequestDetails customerRequestDetails = getCustomerRequestDetails();
		CustomerRequestDetails customerRequestDetails = (CustomerRequestDetails) getMyBean("customerRequestDetails");
		customerRequestDetails.setType(requestType);
		customerRequestDetails.setDescription(requestDescription);
		customerRequestDao.submitRequest(customerRequestDetails);
	}


}
