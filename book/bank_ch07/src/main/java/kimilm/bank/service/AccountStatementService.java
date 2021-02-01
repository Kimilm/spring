package kimilm.bank.service;

import java.util.Date;

import kimilm.bank.domain.AccountStatement;

public interface AccountStatementService {
	AccountStatement getAccountStatement(Date from, Date to);
}
