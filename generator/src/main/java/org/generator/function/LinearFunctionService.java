package org.generator.function;

import java.util.List;

import org.apache.log4j.Logger;
import org.generator.polynomial.RootsGenerator;

import pl.tasks.model.LinearFunction;

public class LinearFunctionService {

	RootsGenerator generator = new RootsGenerator();
	private Logger logger = Logger.getLogger(LinearFunctionService.class);

	public double valueFuncionInPoint(double point, double divisor) {
		List<Integer> linearCoefficients = generator.rootsOfPolynomial(2, 20);
		LinearFunction linearFunction = new LinearFunction(
				linearCoefficients.get(0) / divisor, linearCoefficients.get(1)
						/ divisor);
		logger.info("Linear Coefficients: " + linearFunction);
		double valueFuncionInPoint = linearFunction.getCoefficientNextToX()
				* point + linearFunction.getFreeExpression();
		return valueFuncionInPoint;
	}

}
