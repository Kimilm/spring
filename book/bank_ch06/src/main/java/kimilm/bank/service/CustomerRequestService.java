package kimilm.bank.service;

public interface CustomerRequestService extends MyService {
	void submitRequest(String requestType, String requestDescription);
}
