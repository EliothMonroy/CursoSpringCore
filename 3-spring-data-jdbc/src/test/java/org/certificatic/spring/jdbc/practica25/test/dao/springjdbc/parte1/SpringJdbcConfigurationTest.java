package org.certificatic.spring.jdbc.practica25.test.dao.springjdbc.parte1;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = "classpath:/spring/practica25/spring-jdbc-application-context.xml")
@ActiveProfiles("h2-in-memory")
public class SpringJdbcConfigurationTest {

	@Autowired
	private DataSource datasource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Before
	public void setUp() {
		Assert.assertNotNull(datasource);
		Assert.assertNotNull(jdbcTemplate);
		Assert.assertNotNull(namedJdbcTemplate);
	}

	@Test
	public void test() {
		Assert.assertSame(datasource, jdbcTemplate.getDataSource());
		Assert.assertSame(datasource,
				((JdbcTemplate) namedJdbcTemplate.getJdbcOperations())
						.getDataSource());

		String query = "SELECT 1";

		int number = jdbcTemplate.queryForObject(query, Integer.class);

		Assert.assertEquals(1, number);

		log.info("query {}: {}", query, number);
	}
}
