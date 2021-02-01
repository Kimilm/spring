package kimilm.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import kimilm.bank.dao.TransactionDao;
import kimilm.bank.dao.TransactionDaoImpl;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDao transactionDao;

	@Override
	public void getTransactions(String customerId) {
		transactionDao.getTransactions(customerId);
	}

	@Bean
	public TransactionDao transactionDao() {
		return new TransactionDaoImpl();
	}
}
