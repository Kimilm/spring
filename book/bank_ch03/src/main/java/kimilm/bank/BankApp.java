package kimilm.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kimilm.bank.controller.FixedDepositController;
import kimilm.bank.controller.PersonalBankingController;
import kimilm.bank.controller.UserRequestController;
import kimilm.bank.domain.FixedDepositDetails;
import kimilm.bank.domain.Request;
import kimilm.bank.service.FixedDepositService2;

public class BankApp {
	private static Logger logger = LogManager.getLogger(BankApp.class);

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");

		FixedDepositController fixedDepositController = context
				.getBean(FixedDepositController.class);
		fixedDepositController.submit(context
				.getBean(FixedDepositDetails.class).setDepositAmount(100)
				.setEmail("someemail@somedomain.com").setId(1).setTenure(10));
		logger.info("Your fixed deposit details : "
				+ fixedDepositController.get());

		PersonalBankingController personalBankingController = context
				.getBean(PersonalBankingController.class);
		logger.info(personalBankingController.getMiniStatement());

		UserRequestController userRequestController = context
				.getBean(UserRequestController.class);
		userRequestController.submitRequest(new Request());
		logger.info("Submitted user request");
		
		FixedDepositService2 fixedDepositService2 = (FixedDepositService2) context.getBean("service");

		fixedDepositService2.createFixedDeposit(new FixedDepositDetails(101, 10000, 60, "someemail@somedomain.com"));

		logger.info("Invoking getBean(\"eventFactory\") returns : " + context.getBean("eventSenderFactory"));
		logger.info("Invoking getBean(\"&eventFactory\") returns : " + context.getBean("&eventSenderFactory"));
	}
}
