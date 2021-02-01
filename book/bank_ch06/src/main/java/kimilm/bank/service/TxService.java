package kimilm.bank.service;

import java.util.List;

import kimilm.bank.domain.Tx;

public interface TxService extends MyService {
	List<Tx> getTransactions(int accountNumber);
}
