package kimilm.bank;

public class FixedDepositDaoFactory {
	public FixedDepositDaoFactory() {
	}

	public static FixedDepositDao getFixedDepositDao(String daoType) {
		FixedDepositDao fixedDepositDao = null;

		if ("jdbc".equalsIgnoreCase(daoType)) {
			if (fixedDepositDao == null) {
				fixedDepositDao = new FixedDepositDao();
			}
		} else if ("Mybatis".equalsIgnoreCase(daoType)) {
			if (fixedDepositDao == null) {
				fixedDepositDao = new FixedDepositDao();
			}
		} else if ("jpa".equalsIgnoreCase(daoType)) {
			if (fixedDepositDao == null) {
				fixedDepositDao = new FixedDepositDao();
			}
		}
		return fixedDepositDao;
	}

}
