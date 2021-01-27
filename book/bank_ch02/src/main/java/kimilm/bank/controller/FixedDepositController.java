package kimilm.bank.controller;

import kimilm.bank.domain.FixedDepositDetails;
import kimilm.bank.service.FixedDepositService;

public interface FixedDepositController {
	FixedDepositService getFixedDepositService();

	boolean submit();

	FixedDepositDetails get();
}
