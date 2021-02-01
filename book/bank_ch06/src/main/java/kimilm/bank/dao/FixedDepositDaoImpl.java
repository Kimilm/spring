package kimilm.bank.dao;

import org.springframework.stereotype.Repository;

import kimilm.bank.domain.FixedDepositDetails;

@Repository(value="myFixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		// -- save the fixed deposits and then return true
		return true;
	}
}
