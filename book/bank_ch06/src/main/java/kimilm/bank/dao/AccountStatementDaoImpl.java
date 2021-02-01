package kimilm.bank.dao;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import kimilm.bank.domain.AccountStatement;

@Repository(value="accountStatementDao")
public class AccountStatementDaoImpl implements AccountStatementDao {
	private static Logger logger = LogManager.getLogger(AccountStatementDaoImpl.class);
	
	@Override
	public AccountStatement getAccountStatement(Date from, Date to) {
		logger.info("Getting account statement");
		return new AccountStatement();
	}

}
