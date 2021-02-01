package kimilm.bank.repository;

import java.util.List;

import kimilm.bank.domain.FixedDepositDetails;

public interface FixedDepositRepositoryCustom {
	List<FixedDepositDetails> findByTenure(int tenure);
}
