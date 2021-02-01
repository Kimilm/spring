package kimilm.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kimilm.bank.domain.Tx;

@Repository(value = "txDao")
@Qualifier("myTx")
public class TxDaoImpl implements TxDao {

	@Override
	public List<Tx> getTransactions(int accountNumber) {
		List<Tx> txList = new ArrayList<Tx>();
		txList.add(new Tx(1, "High value money transfer", "complete"));
		txList.add(new Tx(2, "High value money transfer", "in process"));
		return txList;
	}
}
