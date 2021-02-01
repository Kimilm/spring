package kimilm.bank.dao;

import java.util.List;

import kimilm.bank.domain.FixedDepositDetails;

public interface FixedDepositDao {
	int createFixedDeposit(FixedDepositDetails fdd);
	FixedDepositDetails getFixedDeposit(int fixedDepositId);
	List<FixedDepositDetails> getInactiveFixedDeposits();
	void setFixedDepositsAsActive(List<FixedDepositDetails> fds);
	List<FixedDepositDetails> findFixedDepositsByBankAccount(int bankAccountId);
}
