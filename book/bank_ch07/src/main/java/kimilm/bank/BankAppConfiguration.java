package kimilm.bank;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import kimilm.bank.dao.AccountStatementDao;
import kimilm.bank.dao.AccountStatementDaoImpl;
import kimilm.bank.dao.CustomerRegistrationDao;
import kimilm.bank.dao.CustomerRegistrationDaoImpl;
import kimilm.bank.dao.FixedDepositDao;
import kimilm.bank.dao.FixedDepositDaoImpl;
import kimilm.bank.domain.CustomerRegistrationDetails;
import kimilm.bank.service.AccountStatementService;
import kimilm.bank.service.AccountStatementServiceImpl;
import kimilm.bank.service.CustomerRegistrationService;
import kimilm.bank.service.CustomerRegistrationServiceImpl;
import kimilm.bank.service.FixedDepositService;
import kimilm.bank.service.FixedDepositServiceImpl;

@Configuration
public class BankAppConfiguration {
	
	@Bean(name = "accountStatementService")
	public AccountStatementService accountStatementService() {
		AccountStatementServiceImpl accountStatementServiceImpl = new AccountStatementServiceImpl();
		accountStatementServiceImpl.setAccountStatementDao(accountStatementDao());
		return accountStatementServiceImpl;
	}

	@Bean(name = "accountStatementDao")
	public AccountStatementDao accountStatementDao() {
		return new AccountStatementDaoImpl();
	}

	@Bean(name = "customerRegistrationService")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CustomerRegistrationService customerRegistrationService() {
		return new CustomerRegistrationServiceImpl();
	}

	@Bean(name = "customerRegistrationDao")
	public CustomerRegistrationDao customerRegistrationDao() {
		return new CustomerRegistrationDaoImpl();
	}

	@Bean(name = "customerRegistrationDetails")
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public CustomerRegistrationDetails customerRegistrationDetails() {
		return new CustomerRegistrationDetails();
	}

	@Bean(name = "fixedDepositService")
	public FixedDepositService fixedDepositService() {
		return new FixedDepositServiceImpl();
	}

	@Bean
	public FixedDepositDao fixedDepositDao() {
		return new FixedDepositDaoImpl();
	}
}