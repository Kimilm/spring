package kimilm.bank.dao;

import kimilm.bank.domain.CustomerRequestDetails;

public interface CustomerRequestDao {
	void submitRequest(CustomerRequestDetails userRequestDetails);
}
