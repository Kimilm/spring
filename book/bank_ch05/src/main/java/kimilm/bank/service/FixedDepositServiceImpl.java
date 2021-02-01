package kimilm.bank.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kimilm.bank.common.DependencyResolver;
import kimilm.bank.common.MyApplicationContext;
import kimilm.bank.dao.FixedDepositDao;
import kimilm.bank.domain.FixedDepositDetails;

public class FixedDepositServiceImpl implements FixedDepositService, DependencyResolver {
	private static Logger logger = LogManager.getLogger(FixedDepositServiceImpl.class);
	private FixedDepositDao myFixedDepositDao;

	public void setMyFixedDepositDao(FixedDepositDao myFixedDepositDao) {
		logger.info("FixedDepositServiceImpl's setMyFixedDepositDao method invoked");
		this.myFixedDepositDao = myFixedDepositDao;
	}

	@Override
	public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
		// -- create fixed deposit
		myFixedDepositDao.createFixedDeposit(fdd);
	}

	@Override
	public void resolveDependency(MyApplicationContext myApplicationContext) {
		myFixedDepositDao = myApplicationContext.getBean(FixedDepositDao.class);
	}
}
