package kimilm.bank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kimilm.bank.controller.FixedDepositController;
import kimilm.bank.domain.FixedDepositDetails;

public class BankApp {
	private static Logger logger = LogManager.getLogger(BankApp.class);

	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");

		FixedDepositController fixedDepositController = (FixedDepositController) context
				.getBean("controller");

		logger.info("Submission status of fixed deposit : "
				+ fixedDepositController.submit());
		logger.info("Returned fixed deposit info : "
				+ fixedDepositController.get());
		
		FixedDepositController controller1 = (FixedDepositController) context
				.getBean("controller");
		FixedDepositController controller2 = (FixedDepositController) context
				.getBean("controller");

		FixedDepositDetails fixedDepositDetails1 = (FixedDepositDetails) context
				.getBean("fixedDepositDetails");
		FixedDepositDetails fixedDepositDetails2 = (FixedDepositDetails) context
				.getBean("fixedDepositDetails");

		if (controller1 == controller2) {
			logger.info("Same FixedDepositController instance");
		} else {
			logger.info("Different FixedDepositController instances");
		}
		if (fixedDepositDetails1 == fixedDepositDetails2) {
			logger.info("Same FixedDepositDetails instance");
		} else {
			logger.info("Different FixedDepositDetails instances");
		}
	}
}
