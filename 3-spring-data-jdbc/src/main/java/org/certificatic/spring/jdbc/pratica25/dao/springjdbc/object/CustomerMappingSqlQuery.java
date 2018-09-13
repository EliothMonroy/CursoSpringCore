package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.certificatic.spring.jdbc.pratica25.dao.springjdbc.rowmapper.CustomerRowMapper;
import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public class CustomerMappingSqlQuery extends MappingSqlQuery<Customer> {

	private static final String SELECT = "SELECT * FROM SPRING_DATA_CUSTOMER_TBL INNER JOIN SPRING_DATA_USER_TBL ON CUSTOMER_ID=FK_CUSTOMER_ID WHERE CUSTOMER_ID = ?";

	private CustomerRowMapper customerRowMapper = new CustomerRowMapper();

	public CustomerMappingSqlQuery(DataSource dataSource) {

		super(dataSource, SELECT);
		declareParameter(new SqlParameter("CUSTOMER_ID", Types.INTEGER));
		compile();
	}

	@Override
	protected Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return customerRowMapper.mapRow(rs, rowNum);
	}

}
