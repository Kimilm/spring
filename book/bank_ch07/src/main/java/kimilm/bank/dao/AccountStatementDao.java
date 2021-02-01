package kimilm.bank.dao;

import java.util.Date;

import kimilm.bank.domain.AccountStatement;

public interface AccountStatementDao {
	public AccountStatement getAccountStatement(Date from, Date to);
}
