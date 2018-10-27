package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.object;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class CustomerSqlUpdate extends SqlUpdate {

	private static final String UPDATE = "UPDATE CUSTOMER_TBL SET NAME = ?, LAST_NAME = ? WHERE CUSTOMER_ID = ?";

	public CustomerSqlUpdate(DataSource dataSource) {

		super(dataSource, UPDATE);
		declareParameter(new SqlParameter("NAME", Types.VARCHAR));
		declareParameter(new SqlParameter("LAST_NAME", Types.VARCHAR));
		declareParameter(new SqlParameter("CUSTOMER_ID", Types.INTEGER));

		compile();
	}

	public int execute(Long id, String name, String lastName) {
		return update(name, lastName, id);
	}

}
