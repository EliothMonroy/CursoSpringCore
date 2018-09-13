package org.certificatic.spring.core.practica19.javaconfig.bean.api;

import org.apache.commons.math3.complex.Complex;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class QuadraticEquationResult {
	private @Setter(AccessLevel.NONE) Complex x1;
	private @Setter(AccessLevel.NONE) Complex x2;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("x1 = ");
		sb.append(x1).append(", x2 = ").append(x2);

		return sb.toString();
	}

}