package org.generator.sequences;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.generator.polynomial.RootsGenerator;

import pl.tasks.model.GeometricSequence;

public class GeometricSequencesGenerator {

	private static final Logger logger = Logger
			.getLogger(GeometricSequencesGenerator.class);
	private RootsGenerator rootsGenerator = new RootsGenerator();
	private int firstExpressionOfSequence;
	private int quotient;

	public void geometricParametersGenerator() {
		List<Integer> parameters = rootsGenerator.rootsOfPolynomial(2, 20);
		this.firstExpressionOfSequence = parameters.get(0);
		this.quotient = parameters.get(1);
	}

	public void setRootsGenerator(RootsGenerator rootsGenerator) {
		this.rootsGenerator = rootsGenerator;
	}

	public int getFirstExpressionOfSequence() {
		return firstExpressionOfSequence;
	}

	public void setFirstExpressionOfSequence(int firstExpressionOfSequence) {
		this.firstExpressionOfSequence = firstExpressionOfSequence;
	}

	public int getQuotient() {
		return quotient;
	}

	public void setQuotient(int quotient) {
		this.quotient = quotient;
	}

	public List<GeometricSequence> valuesOfExpressionGeometricSequence(int n) {
		geometricParametersGenerator();
		List<GeometricSequence> valueOfExpressionGeometricSequence = new ArrayList<GeometricSequence>();
		int valueOfExpressionGS = firstExpressionOfSequence;
		valueOfExpressionGeometricSequence.add(new GeometricSequence(1,
				firstExpressionOfSequence));
		for (int i = 1; i < n; i++) {
			valueOfExpressionGS = valueOfExpressionGS * quotient;
			valueOfExpressionGeometricSequence.add(new GeometricSequence(i + 1,
					valueOfExpressionGS));
		}
		logger.info("First expression: " + firstExpressionOfSequence);
		logger.info("Quotient: " + quotient);
		logger.info("Geometric Sequence: " + valueOfExpressionGeometricSequence);
		return valueOfExpressionGeometricSequence;
	}

	public String toString() {
		return "an = " + Integer.toString(firstExpressionOfSequence) + "*("
				+ Integer.toString(quotient) + "^n)";
	}
}
