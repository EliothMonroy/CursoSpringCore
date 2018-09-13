package org.certificatic.spring.core.practica21.spel.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Society {
	private String name;

	public static String Advisors = "advisors";
	public static String President = "president";

	private List<Inventor> members = new ArrayList<Inventor>();
	private Map<String, Object> officers = new HashMap<String, Object>();

	public boolean isMember(String name) {
		Inventor inventor = this.getMember(name);
		return inventor != null ? true : false;
	}

	public Inventor getMember(String name) {
		for (Inventor inventor : members) {
			if (inventor.getName().equals(name)) {
				return inventor;
			}
		}
		return null;
	}

}
