package kimilm.bank.service;

import kimilm.bank.domain.FixedDepositDetails;


public interface FixedDepositService extends MyService {
	void createFixedDeposit(FixedDepositDetails fdd) throws Exception;
}
