package kimilm.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import kimilm.bank.domain.FixedDepositDetails;

@Repository(value="fixedDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	/*
	@Override
	public int createFixedDeposit(FixedDepositDetails fdd) {
		final String sql = "insert into fixed_deposit_details"
				+ "(account_id, fd_creation_date, amount, tenure, active) "
				+ "values(?, ?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"fixed_deposit_id"});
				ps.setInt(1, fdd.getBankAccountId());
				ps.setDate(2, new java.sql.Date(fdd.getFdCreationDate().getTime()));
				ps.setInt(3, fdd.getFdAmount());
				ps.setInt(4, fdd.getTenure());
				ps.setString(5, fdd.getActive());
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	} */
	
	@Override
	public int createFixedDeposit(final FixedDepositDetails fixedDepositDetails) {
		sessionFactory.getCurrentSession().save(fixedDepositDetails);
		return fixedDepositDetails.getFixedDepositId();
	}

	/*
	@Override
	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
		final String sql = "select * from fixed_deposit_details"
				+ "where fixed_deposit_id = :fixedDepositId";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("fixedDepositId", fixedDepositId);
		
		return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, 
				new RowMapper<FixedDepositDetails>() {
			public FixedDepositDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				FixedDepositDetails fdd = new FixedDepositDetails();
				fdd.setActive(rs.getString("active"));
				fdd.setBankAccountId(rs.getInt("account_id"));
				fdd.setFdAmount(rs.getInt("amount"));
				fdd.setFdCreationDate(rs.getDate("fd_creation_date"));
				fdd.setFixedDepositId(rs.getInt("fixed_deposit_id"));
				fdd.setTenure(rs.getInt("tenure"));
				return fdd;
			}
		});
	} */
	
	@Override
	public FixedDepositDetails getFixedDeposit(final int fixedDepositId) {
		String hql = "from FixedDepositDetails as fixedDepositDetails where "
				+ "fixedDepositDetails.fixedDepositId = " + fixedDepositId;
		
		return (FixedDepositDetails) sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
	}
	

}
