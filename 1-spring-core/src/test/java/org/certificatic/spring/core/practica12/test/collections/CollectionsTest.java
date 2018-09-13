package org.certificatic.spring.core.practica12.test.collections;

import org.certificatic.spring.core.practica12.collections.bean.AddressBook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionsTest {

	private static ClassPathXmlApplicationContext applicationContext;

	@Before
	public void beforeTest() {
		applicationContext = new ClassPathXmlApplicationContext(
				"spring/practica12/collections-application-context.xml");
	}

	@Test
	public void collectionsTest() {

		log.info("collectionsTest -------------------");

		AddressBook addressBook = applicationContext.getBean(AddressBook.class);

		Assert.assertNotNull(addressBook);

		log.info("addressBook: {}", addressBook);

		((AbstractApplicationContext) applicationContext).close();
	}

}
