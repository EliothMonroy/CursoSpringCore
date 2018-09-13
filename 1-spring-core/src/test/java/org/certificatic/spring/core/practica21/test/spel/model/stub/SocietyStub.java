package org.certificatic.spring.core.practica21.test.spel.model.stub;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.certificatic.spring.core.practica21.spel.model.Inventor;
import org.certificatic.spring.core.practica21.spel.model.PlaceOfBirth;
import org.certificatic.spring.core.practica21.spel.model.Society;

public class SocietyStub {

	public static Society createSociety(String name) {
		return Society.builder().name(name).members(createInventors()).officers(createOfficers()).build();
	}

	public static Map<String, Object> createOfficers() {

		Map<String, Object> hashMap = new HashMap<>();

		hashMap.put("president", createPresident());
		hashMap.put("advisors", createAdvisors());

		return hashMap;
	}

	public static List<Inventor> createAdvisors() {
		List<Inventor> list = new ArrayList<>();

		list.add(createIgnazioPorro());
		list.add(createNikolayPopov());
		list.add(createJosephSwan());
		list.add(createRudolfVirchow());

		return list;
	}

	public static Inventor createRudolfVirchow() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1821, 10, 13);

		Inventor inventor = new Inventor("Rudolf Carl Virchow", c.getTime(), "Prussian");
		inventor.setInventions(new String[] { "standardised Autopsy protocols" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Prussia").city("Schivelbein").build());

		return inventor;
	}

	public static Inventor createJosephSwan() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1828, 10, 31);

		Inventor inventor = new Inventor("Sir Joseph Swan", c.getTime(), "British");
		inventor.setInventions(new String[] { "Incandescent light bulb" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("England").city("Bishopwearmouth").build());

		return inventor;
	}

	public static Inventor createNikolayPopov() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1931, 12, 14);

		Inventor inventor = new Inventor("Mihajlo Idvorski Pupin", c.getTime(), "Russian");
		inventor.setInventions(new String[] { "first fully gas turbine main battle tank (T-80)" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Russia").build());

		return inventor;
	}

	public static Inventor createIgnazioPorro() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1801, 11, 25);

		Inventor inventor = new Inventor("Ignazio Porro", c.getTime(), "Italian");
		inventor.setInventions(new String[] { "Porro prism", "Strip camera" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Italia").build());

		return inventor;
	}

	public static Inventor createPresident() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1858, 10, 9);

		Inventor inventor = new Inventor("Mihajlo Idvorski Pupin", c.getTime(), "Serbian");
		inventor.setInventions(new String[] { "pupinization (loading coils)", "tunable oscillator" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Serbia").city("Village of Idvor").build());

		return inventor;
	}

	public static List<Inventor> createInventors() {

		List<Inventor> list = new ArrayList<>();

		list.add(createBruceAmes());
		list.add(createAnatolyAlexandrov());
		list.add(createTesla());
		list.add(createEdwinHowardArmstrong());
		list.add(createCharlesBabbage());
		list.add(createMichaelFaraday());
		list.add(createMikhailKalashnikov());
		list.add(createBlaisePascal());
		list.add(createAlbertEinstein());

		return list;
	}

	public static Inventor createAlbertEinstein() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1879, 3, 14);

		Inventor inventor = new Inventor("Albert Einstein", c.getTime(), "German");
		inventor.setInventions(
				new String[] { "absorption refrigerator", "quantum theory", "theory of general relativity" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Germany").build());

		return inventor;
	}

	public static Inventor createMikhailKalashnikov() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1919, 11, 10);

		Inventor inventor = new Inventor("Mikhail Kalashnikov", c.getTime(), "Russian");
		inventor.setInventions(new String[] { "AK-47 assault rifle", "AK-74 assault rifle" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Russia").city("Kurya").build());

		return inventor;
	}

	public static Inventor createMichaelFaraday() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1791, 9, 22);

		Inventor inventor = new Inventor("Michael Faraday", c.getTime(), "British");
		inventor.setInventions(new String[] { "electric transformer", "electric motor" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("England").city("Hampton Court").build());

		return inventor;
	}

	public static Inventor createAnatolyAlexandrov() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1903, 2, 13);

		Inventor inventor = new Inventor("Anatoly Alexandrov", c.getTime(), "Russian");
		inventor.setInventions(new String[] { "anti-mine demagnetising of ships",
				"naval nuclear reactors (including one for the first nuclear icebreaker)" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Russia").city("Moscow").build());

		return inventor;
	}

	public static Inventor createEdwinHowardArmstrong() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1890, 12, 18);

		Inventor inventor = new Inventor("Edwin H. Armstrong", c.getTime(), "American");
		inventor.setInventions(new String[] { "FM radio" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("U.S.").city("New York").build());

		return inventor;
	}

	public static Inventor createBlaisePascal() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1623, 6, 19);

		Inventor inventor = new Inventor("Blaise Pascal", c.getTime(), "French");
		inventor.setInventions(new String[] { "Pascal's calculator" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("France").city("Clermont-Ferrand").build());

		return inventor;
	}

	public static Inventor createCharlesBabbage() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1791, 12, 26);

		Inventor inventor = new Inventor("Charles Babbage", c.getTime(), "English");
		inventor.setInventions(new String[] { "analytical engine (semi-automatic)" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("England").city("London").build());

		return inventor;
	}

	public static Inventor createTesla() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1856, 7, 9);

		Inventor inventor = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
		inventor.setInventions(new String[] { "induction motor", "high-voltage / high-frequency power experiments",
				"the transmission of electrical power" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("Serbia").build());

		return inventor;
	}

	public Inventor createInventorTesla() {
		return createTesla();
	}

	public static Inventor createBruceAmes() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(1928, 12, 16);

		Inventor inventor = new Inventor("Bruce Ames", c.getTime(), "American");
		inventor.setInventions(new String[] { "Ames test (cell biology)" });
		inventor.setPlaceOfBirth(PlaceOfBirth.builder().country("U.S.").city("New York").build());

		return inventor;
	}
}
