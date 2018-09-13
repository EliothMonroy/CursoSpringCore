package org.certificatic.spring.core.practica12.collections.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;

@Data
public class AddressBook {
	private List<Address> addresses;
	private Set<Phone> phones;
	private Map<Integer, String> emergencyNumbers;
	private Properties family;

	private Integer[] numbers;
	private String[] notes;
	private Person[] persons;

	@Override
	public String toString() {
		String msg = "addresses: " + addresses + "\n" + "phones: "
				+ phones + "\n" + "emergencyNumbers: "
				+ emergencyNumbers + "\n" + "family: " + family
				+ "\n" + "numbers: " + Arrays.deepToString(numbers) + "\n"
				+ "notes: " + Arrays.deepToString(notes) + "\n"
				+ "persons: " + Arrays.deepToString(persons);
		return msg;
	}
}
