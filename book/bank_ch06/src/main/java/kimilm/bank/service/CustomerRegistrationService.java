package kimilm.bank.service;

public interface CustomerRegistrationService extends MyService {
	void setAccountNumber(String accountNumber);
	void setAddress(String address);
	void setDebitCardNumber(String cardNumber);
	void register();
}
