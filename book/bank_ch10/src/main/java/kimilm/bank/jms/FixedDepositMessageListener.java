package kimilm.bank.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import kimilm.bank.dao.BankAccountDao;
import kimilm.bank.dao.FixedDepositDao;
import kimilm.bank.domain.FixedDepositDetails;

public class FixedDepositMessageListener implements MessageListener{
	private static Logger logger = LogManager.getLogger(FixedDepositMessageListener.class);

	@Autowired
	@Qualifier(value = "fixedDepositDao")
	private FixedDepositDao myFixedDepositDao;

	@Autowired
	private BankAccountDao bankAccountDao;
	
	@Transactional("dbTxManager")
	public int createFixedDeposit(FixedDepositDetails fixedDepositDetails) {
		// -- create fixed deposit
		bankAccountDao.subtractFromAccount(fixedDepositDetails.getBankAccountId(), fixedDepositDetails.getFixedDepositId());
		return myFixedDepositDao.createFixedDeposit(fixedDepositDetails);
	}

	@Override
	public void onMessage(Message message) {
		logger.info("FixedDepositMessageListener's onMessage() invoked");
		ObjectMessage objectMessage = (ObjectMessage) message;
		FixedDepositDetails fixedDepositDetails = null;
		
		try {
			fixedDepositDetails = (FixedDepositDetails) objectMessage.getObject();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
		if (fixedDepositDetails != null) {
			createFixedDeposit(fixedDepositDetails);
		}
	}
	
}
