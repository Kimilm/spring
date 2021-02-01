package kimilm.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kimilm.bank.dao.TxDao;
import kimilm.bank.domain.Tx;

@Service("txService")
@Qualifier("service")
public class TxServiceImpl implements TxService {
	@Autowired
	@Qualifier("myTx")
	private TxDao txDao;

	@Override
	public List<Tx> getTransactions(int accountNumber) {
		// --get high value transactions corresponding to the accountNumber
		return txDao.getTransactions(accountNumber);
	}
}
