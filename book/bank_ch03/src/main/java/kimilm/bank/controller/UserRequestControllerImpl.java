package kimilm.bank.controller;

import java.beans.ConstructorProperties;

import kimilm.bank.base.ServiceTemplate;
import kimilm.bank.domain.Request;

public class UserRequestControllerImpl implements UserRequestController {
	private ServiceTemplate serviceTemplate;
	
	@ConstructorProperties({"serviceTemplate"})
	public UserRequestControllerImpl(ServiceTemplate serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}
	
	public void setServiceTemplate(ServiceTemplate serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}
	
	@Override
	public void submitRequest(Request request) {
		//-- do something using ServiceTemplate
		serviceTemplate.getJmsMessageSender(); //-- For ex., send JMS message
	}
}
