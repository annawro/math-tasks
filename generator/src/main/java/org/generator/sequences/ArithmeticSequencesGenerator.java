package org.generator.sequences;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.generator.polynomial.RootsGenerator;

import pl.tasks.model.ArithmeticSequence;

public class ArithmeticSequencesGenerator {

	private static final Logger logger = Logger
			.getLogger(ArithmeticSequencesGenerator.class);
	private RootsGenerator generator = new RootsGenerator();
	private int firstExpressionOfSequence;
	private int difference;
	private List<ArithmeticSequence> valuesOfArithmeticSequence = new ArrayList<ArithmeticSequence>();

	public void arithmeticParameterGenerator() {
		List<Integer> parameters = generator.rootsOfPolynomial(2, 10);
		this.firstExpressionOfSequence = parameters.get(0);
		this.difference = parameters.get(1);
	}

	public void setFirstExpressionOfSequence(int firstExpressionOfSequence) {
		this.firstExpressionOfSequence = firstExpressionOfSequence;
	}

	public void setDifference(int difference) {
		this.difference = difference;
	}

	public void setGenerator(RootsGenerator generator) {
		this.generator = generator;
	}

	public List<ArithmeticSequence> getValuesOfArithmeticSequence() {
		return valuesOfArithmeticSequence;
	}

	public void setValuesOfArithmeticSequence(
			List<ArithmeticSequence> valuesOfArithmeticSequence) {
		this.valuesOfArithmeticSequence = valuesOfArithmeticSequence;
	}

	public List<ArithmeticSequence> valuesOfArithmeticSequence(int n) {
		arithmeticParameterGenerator();
		for (int i = 1; i < n + 1; i++) {
			int expressionOfSequence = firstExpressionOfSequence + (i - 1)
					* difference;
			valuesOfArithmeticSequence.add(new ArithmeticSequence(i,
					expressionOfSequence));
		}
		logger.info("First expression:" + firstExpressionOfSequence);
		logger.info("Difference:" + difference);
		logger.info("ArithmeticSequence:" + valuesOfArithmeticSequence);
		return valuesOfArithmeticSequence;
	}

	public String toString() {
		return "an = " + Integer.toString(firstExpressionOfSequence) + " + "
				+ "(n-1)*" + Integer.toString(difference);
	}
}
