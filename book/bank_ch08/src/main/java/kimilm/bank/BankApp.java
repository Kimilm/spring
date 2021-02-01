package kimilm.bank;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kimilm.bank.domain.BankAccountDetails;
import kimilm.bank.domain.FixedDepositDetails;
import kimilm.bank.service.BankAccountService;
import kimilm.bank.service.FixedDepositService;

class BankApp {
	private static Logger logger = LogManager.getLogger(BankApp.class);
	public static void main (String [] args) throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
		
		BankAccountService bankAccountService = context.getBean(BankAccountService.class);
		BankAccountDetails bankAccountDetails = new BankAccountDetails();
		bankAccountDetails.setBalanceAmount(1000);
		bankAccountDetails.setLastTransactionTimeStamp(new Date());
		
		int bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);
		
		logger.info("Created bank account with id - " + bankAccountId);
		
		FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
		FixedDepositDetails fdd = new FixedDepositDetails();
		fdd.setActive("Y");
		fdd.setBankAccountId(bankAccountDetails);
		fdd.setFdCreationDate(new Date());
		fdd.setFdAmount(500);
		fdd.setTenure(12);
		int fixedDepositId = fixedDepositService.createFixedDeposit(fdd);
		
		logger.info("Created fixed deposit with id - " + fixedDepositId);
		
		context.close();		
	}
}