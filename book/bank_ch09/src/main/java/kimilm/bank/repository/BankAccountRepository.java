package kimilm.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kimilm.bank.domain.BankAccountDetails;
import kimilm.bank.domain.FixedDepositDetails;

public interface BankAccountRepository extends JpaRepository<BankAccountDetails, Integer>, 
	BankAccountRepositoryCustom, QuerydslPredicateExecutor<FixedDepositDetails> {
	
}
