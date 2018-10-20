package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.certificatic.spring.jdbc.pratica25.domain.entities.Customer;
import org.certificatic.spring.jdbc.pratica25.domain.entities.User;
import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		Customer customer = new Customer();

		user.setId(rs.getLong("USER_ID"));
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setCustomer(customer);

		customer.setId(rs.getLong("CUSTOMER_ID"));
		customer.setName(rs.getString("NAME"));
		customer.setLastName(rs.getString("LAST_NAME"));
		customer.setUser(user);

		return user;
	}

}
