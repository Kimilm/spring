package kimilm.bank.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="BankAccountDetails")
@Table(name="bank_account_details")
public class BankAccountDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id")
	private int accountId;
	
	@Column(name="balance_amount")
	private int balanceAmount;
	
	@Column(name="last_transaction_ts")
	private Date lastTransactionTimeStamp;
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public Date getLastTransactionTimeStamp() {
		return lastTransactionTimeStamp;
	}
	public void setLastTransactionTimeStamp(Date lastTransactionTimeStamp) {
		this.lastTransactionTimeStamp = lastTransactionTimeStamp;
	}
	@Override
	public boolean equals(Object otherObject) {
		BankAccountDetails otherBankAccountDetails = (BankAccountDetails) otherObject;
		if (otherBankAccountDetails.getAccountId() == this.accountId) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
