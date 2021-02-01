package kimilm.bank.dao;

import java.util.List;

import kimilm.bank.domain.Tx;

public interface TxDao {
	List<Tx> getTransactions(int accountNumber);
}
