package org.certificatic.spring.core.practica19.javaconfig.bean.api;

public interface IQuadraticEquationService {

	// ax^2 + bx + c = 0  => (x1, x2)
	QuadraticEquationResult solve(double a, double b, double c);

	default String quadraticEquationToString(double a, double b, double c) {
		StringBuilder sb = new StringBuilder();

		sb.append(a).append("x^2").append(b > 0 ? " + " : " - ")
				.append(b < 0 ? -1 * b : b).append("x")
				.append(c > 0 ? " + " : " - ").append(c < 0 ? -1 * c : c)
				.append(" = 0");

		return sb.toString();
	}
}
