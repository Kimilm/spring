package kimilm.bank.service;

import java.util.List;

import kimilm.bank.domain.FixedDepositDetails;

public interface FixedDepositService {
	void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
	FixedDepositDetails getFixedDeposit(int fixedDepositId);
	List<FixedDepositDetails> findFixedDepositsByBankAccount(int bankAccountId);
	FixedDepositDetails getFixedDepositFromCache(int fixedDepositId);
}
