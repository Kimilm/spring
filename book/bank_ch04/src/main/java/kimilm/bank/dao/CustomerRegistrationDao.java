package kimilm.bank.dao;

import kimilm.bank.domain.CustomerRegistrationDetails;

public interface CustomerRegistrationDao {
	void registerCustomer(
			CustomerRegistrationDetails customerRegistrationDetails);
}
