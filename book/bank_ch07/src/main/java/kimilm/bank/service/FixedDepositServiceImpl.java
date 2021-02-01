package kimilm.bank.service;

import org.springframework.beans.factory.annotation.Autowired;

import kimilm.bank.dao.FixedDepositDao;
import kimilm.bank.domain.FixedDepositDetails;

public class FixedDepositServiceImpl implements FixedDepositService {
	
	@Autowired
	private FixedDepositDao fixedDepositDao;
	
	@Override
	public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
		// -- create fixed deposit
		fixedDepositDao.createFixedDeposit(fdd);
	}
}
