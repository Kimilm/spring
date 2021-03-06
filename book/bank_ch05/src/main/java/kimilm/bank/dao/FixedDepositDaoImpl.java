package kimilm.bank.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kimilm.bank.common.InstanceValidator;
import kimilm.bank.domain.FixedDepositDetails;

public class FixedDepositDaoImpl implements FixedDepositDao, InstanceValidator {
	private static Logger logger = LogManager.getLogger(FixedDepositDaoImpl.class);
	private DatabaseConnection connection;
	
	public FixedDepositDaoImpl() {
		logger.info("FixedDepositDaoImpl's constructor invoked");
	}
	
	@PostConstruct
	public void initializeDbConnection() {
		logger.info("FixedDepositDaoImpl's initializeDbConnection method invoked");
		connection = DatabaseConnection.getInstance();
	}
	
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		logger.info("FixedDepositDaoImpl's createFixedDeposit method invoked");
		// -- save the fixed deposits and then return true
		return true;
	}

	@PreDestroy
	public void releaseDbConnection() {
		logger.info("FixedDepositDaoImpl's releaseDbConnection method invoked");
		connection.releaseConnection();
	}

	@Override
	public void validateInstance() {
		logger.info("FixedDepositDaoImpl's validateInstance method invoked");
		if(connection == null) {
			logger.error("Failed to obtain DatabaseConnection instance");
		}
		
	}
}