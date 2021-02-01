package kimilm.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kimilm.bank.dao.FixedDepositDao;
import kimilm.bank.domain.FixedDepositDetails;

@Service(value="fixedDepositService")
@Qualifier("service")
public class FixedDepositServiceImpl implements FixedDepositService {
	
	@Autowired
	@Qualifier(value="myFixedDepositDao")
	private FixedDepositDao myFixedDepositDao;
	
	@Override
	public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
		// -- create fixed deposit
		myFixedDepositDao.createFixedDeposit(fdd);
	}
}
