package kimilm.bank.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kimilm.bank.domain.BankAccountDetails;

@Repository(value = "bankAccountDao")
public class BankAccountDaoImpl implements BankAccountDao {
	private SimpleJdbcInsert insertBankAccountDetail;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.insertBankAccountDetail = new SimpleJdbcInsert(dataSource)
				.withTableName("bank_account_details")
				.usingGeneratedKeyColumns("account_id");
	}

	/*
	@Override
	public int createBankAccount(BankAccountDetails bankAccountDetails) {
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("balance_amount", bankAccountDetails.getBalanceAmount());
		parameters.put("last_transaction_ts", 
				new java.sql.Date(bankAccountDetails.getLastTransactionTimeStamp().getTime()));
		Number key = insertBankAccountDetail.executeAndReturnKey(parameters);
		return key.intValue();
	}
	*/
	
	@Override
	public int createBankAccount(BankAccountDetails bankAccountDetails) {
		sessionFactory.getCurrentSession().save(bankAccountDetails);
		return bankAccountDetails.getAccountId();
	}

	/*
	@Override
	public void subtrackFromAccount(int bankAccountId, int amount) {
		jdbcTemplate.update("update bank_account_details set balance_amount = ? "
				+ "where account_id = ?"
				, amount, bankAccountId);		
	}
	*/
	
	@Override
	public void subtrackFromAccount(int bankAccountId, int amount) {
		String hql = "from BankAccountDetails as bankAccountDetails where "
				+ "bankAccountDetails.accountId=" + bankAccountId;
		
		BankAccountDetails bankAccountDetails = (BankAccountDetails) sessionFactory
				.getCurrentSession().createQuery(hql).uniqueResult();
		bankAccountDetails.setBalanceAmount(bankAccountDetails
				.getBalanceAmount() - amount);
		sessionFactory.getCurrentSession().merge(bankAccountDetails);
	}
}
