package kimilm.bank.service;

import java.beans.ConstructorProperties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kimilm.bank.base.EmailMessageSender;
import kimilm.bank.base.JmsMessageSender;
import kimilm.bank.base.ServiceTemplate;
import kimilm.bank.base.WebServiceInvoker;
import kimilm.bank.dao.FixedDepositDao;
import kimilm.bank.domain.FixedDepositDetails;

public class FixedDepositServiceImpl extends ServiceTemplate implements FixedDepositService {
	private static Logger logger = LogManager.getLogger(FixedDepositServiceImpl.class);

	private FixedDepositDao fixedDepositDao;

	@ConstructorProperties({"jmsMessageSender","emailMessageSender","webServiceInvoker"})
	public FixedDepositServiceImpl(JmsMessageSender jmsMessageSender,
			EmailMessageSender emailMessageSender,
			WebServiceInvoker webServiceInvoker) {
		super(jmsMessageSender, emailMessageSender, webServiceInvoker);
	}

	public FixedDepositDao getFixedDepositDao() {
		return fixedDepositDao;
	}

	public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
		logger.info("Setting fixedDepositDao property");
		this.fixedDepositDao = fixedDepositDao;
	}

	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDepositDao.getFixedDepositDetails(id);
	}

	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return fixedDepositDao.createFixedDeposit(fdd);
	}
}
