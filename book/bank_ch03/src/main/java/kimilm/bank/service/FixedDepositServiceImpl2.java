package kimilm.bank.service;

import java.util.HashMap;
import java.util.Map;

import kimilm.bank.dao.FixedDepositDao2;
import kimilm.bank.domain.FixedDepositDetails;
import kimilm.bank.event.EventSender;
import kimilm.bank.event.FixedDepositCreatedEvent;

public class FixedDepositServiceImpl2 implements FixedDepositService2 {
	private FixedDepositDao2 fixedDepositDao;
	private EventSender eventSender;
	
	public void setEventSender(EventSender eventSender) {
		this.eventSender = eventSender;
	}
	
	public void setFixedDepositDao(FixedDepositDao2 fixedDepositDao) {
		this.fixedDepositDao = fixedDepositDao;
	}
	
	@Override
	public void createFixedDeposit(FixedDepositDetails fdd) {
		//-- create fixed deposit 
		fixedDepositDao.createFixedDeposit(fdd);
		
		//-- create the event that corresponds to creating fixed deposits
		FixedDepositCreatedEvent event = new FixedDepositCreatedEvent();
		Map<String, Object> eventData = new HashMap<String, Object>();
		eventData.put("amount", fdd.getDepositAmount());
		event.setEventData(eventData);
		
		//--send the event to the event sender
		eventSender.sendEvent(event);
	}
	
}
