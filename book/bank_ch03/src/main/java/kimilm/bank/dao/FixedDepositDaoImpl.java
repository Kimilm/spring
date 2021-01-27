package kimilm.bank.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kimilm.bank.domain.FixedDepositDetails;
import kimilm.bank.utils.DatabaseOperations;

public class FixedDepositDaoImpl implements FixedDepositDao {
	private static Logger logger = LogManager.getLogger(FixedDepositDaoImpl.class);

	private DatabaseOperations databaseOperations;
	
	public void setDatabaseOperations(DatabaseOperations databaseOperations) {
		this.databaseOperations = databaseOperations;
	}

	public FixedDepositDaoImpl() {
		logger.info("initializing");
	}

	public FixedDepositDetails getFixedDepositDetails(long id) {
		return databaseOperations.loadFd(id);
	}

	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return databaseOperations.saveFd(fdd);
	}
}
