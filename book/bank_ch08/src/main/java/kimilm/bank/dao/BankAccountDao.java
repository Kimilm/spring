package kimilm.bank.dao;

import kimilm.bank.domain.BankAccountDetails;

public interface BankAccountDao {
	int createBankAccount(BankAccountDetails bankAccountDetails);
	void subtrackFromAccount(int bankAccountId, int amount);
}
