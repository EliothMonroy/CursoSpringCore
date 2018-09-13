package org.certificatic.spring.core.practica21.spel.model;

import java.util.Date;
import java.util.GregorianCalendar;

import org.certificatic.spring.core.utils.DateUtils;
import org.certificatic.spring.core.utils.DateUtils.CampoFecha;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "inventions" })
public class Inventor {
	private String name;
	private String nationality;
	private String[] inventions;
	private Date birthdate;
	private PlaceOfBirth placeOfBirth;

	public Inventor(String name, String nationality) {
		GregorianCalendar c = new GregorianCalendar();
		this.name = name;
		this.nationality = nationality;
		this.birthdate = c.getTime();
	}

	public Inventor(String name, Date birthdate, String nationality) {
		this.name = name;
		this.nationality = nationality;
		this.birthdate = DateUtils.truncarFecha(birthdate, CampoFecha.DIA);
	}
}
