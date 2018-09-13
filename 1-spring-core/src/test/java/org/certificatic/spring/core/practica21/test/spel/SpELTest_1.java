package org.certificatic.spring.core.practica21.test.spel;

import java.util.Properties;

import org.certificatic.spring.core.practica21.spel.bean.GuessNumber;
import org.certificatic.spring.core.practica21.spel.bean.Magician;
import org.certificatic.spring.core.practica21.spel.configuration.ApplicationConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class SpELTest_1 {

	@Autowired
	private GuessNumber guessNumber;

	@Autowired
	private Magician magician;

	@Value("#{systemProperties}")
	private Properties properties;

	@Before
	public void setUp() {
		Assert.assertNotNull(guessNumber);
		Assert.assertNotNull(magician);
	}

	@Test
	public void spelTest() {

		log.info("spelTest -------------------");

		Assert.assertEquals(guessNumber.getRandomNumber(), magician.getInitialNumber());

		log.info("guessNumber.getRandomNumber(): {}", guessNumber.getRandomNumber());
		log.info("magician.getInitialNumber(): {}", magician.getInitialNumber());
		log.info("properties: {}", properties);
	}

}
