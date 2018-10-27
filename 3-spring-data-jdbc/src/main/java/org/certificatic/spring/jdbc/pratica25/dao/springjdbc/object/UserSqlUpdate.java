package org.certificatic.spring.jdbc.pratica25.dao.springjdbc.object;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UserSqlUpdate extends SqlUpdate {

	private static final String UPDATE = "UPDATE USER_TBL SET PASSWORD = ?, USERNAME = ? WHERE USER_ID = ?";

	public UserSqlUpdate(DataSource dataSource) {

		super(dataSource, UPDATE);
		declareParameter(new SqlParameter("PASSWORD", Types.VARCHAR));
		declareParameter(new SqlParameter("USERNAME", Types.VARCHAR));
		declareParameter(new SqlParameter("USER_ID", Types.INTEGER));

		compile();
	}

	public int execute(Long id, String username, String password) {
		return update(password, username, id);
	}

}
