package org.certificatic.spring.core.practica19.javaconfig.bean.api.impl;

import java.text.DecimalFormat;

import org.apache.commons.math3.complex.Complex;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.IQuadraticEquationService;
import org.certificatic.spring.core.practica19.javaconfig.bean.api.QuadraticEquationResult;

public class QuadraticEquationServiceImpl implements IQuadraticEquationService {

	private DecimalFormat decimalFormater = new DecimalFormat(
			"###,###,##0.00##");

	@Override
	public QuadraticEquationResult solve(double a, double b, double c) {

		double minusB = -1 * b;
		double BQuadraticMinusFourAC = Math.pow(b, 2) - (4 * a * c);
		double twoA = 2 * a;

		double sqrtOperation = 0;

		if (BQuadraticMinusFourAC > 0) {
			sqrtOperation = Math.sqrt(BQuadraticMinusFourAC);

			return QuadraticEquationResult.builder()
					.x1(new Complex(Double.valueOf(decimalFormater
							.format((minusB + sqrtOperation) / twoA))))
					.x2(new Complex(Double.valueOf(decimalFormater
							.format((minusB - sqrtOperation) / twoA))))
					.build();

		} else {
			sqrtOperation = Math.sqrt(-1 * BQuadraticMinusFourAC);

			return QuadraticEquationResult.builder().x1(new Complex(
					Double.valueOf(decimalFormater.format(minusB / twoA)),
					Double.valueOf(
							decimalFormater.format(sqrtOperation / twoA))))
					.x2(new Complex(
							Double.valueOf(
									decimalFormater.format(minusB / twoA)),
							Double.valueOf(decimalFormater
									.format(-sqrtOperation / twoA))))
					.build();
		}

	}

	public void init() {
		System.out.println("initializing Quadratic Equation Service Impl");
	}

	public void destroy() {
		System.out.println("destroying Quadratic Equation Service Impl");
	}

}
