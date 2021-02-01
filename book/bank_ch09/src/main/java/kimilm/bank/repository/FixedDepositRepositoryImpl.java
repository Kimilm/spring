package kimilm.bank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kimilm.bank.domain.FixedDepositDetails;
import kimilm.bank.exceptions.NoFixedDepositFoundException;

public class FixedDepositRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public List<FixedDepositDetails> findByTenure(int tenure) {
		List<FixedDepositDetails> fds = entityManager
				.createQuery("SELECT details from FixedDepositDetails details where details.tenure = :tenure",
						FixedDepositDetails.class)
				.setParameter("tenure", tenure).getResultList();
		if (fds.isEmpty()) {
			throw new NoFixedDepositFoundException("No fixed deposits found");
		}
		return fds;
	}
}
