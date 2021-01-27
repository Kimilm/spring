package kimilm.bank.service;


import java.beans.ConstructorProperties;

import kimilm.bank.base.EmailMessageSender;
import kimilm.bank.base.JmsMessageSender;
import kimilm.bank.base.ServiceTemplate;
import kimilm.bank.base.WebServiceInvoker;
import kimilm.bank.dao.PersonalBakingDao;
import kimilm.bank.domain.BankStatement;


public class PersonalBankingServiceImpl extends ServiceTemplate implements PersonalBankingService {

	private PersonalBakingDao personalBakingDao;
	
	@ConstructorProperties({"jmsMessageSender","emailMessageSender","webServiceInvoker"})
	public PersonalBankingServiceImpl(JmsMessageSender jmsMessageSender,
			EmailMessageSender emailMessageSender,
			WebServiceInvoker webServiceInvoker) {
		super(jmsMessageSender, emailMessageSender, webServiceInvoker);
	}

	public void setPersonalBankingDao(PersonalBakingDao personalBakingDao) {
		this.personalBakingDao = personalBakingDao;
	}

	@Override
	public BankStatement getMiniStatement() {
		return personalBakingDao.getMiniStatement();
	}
}
