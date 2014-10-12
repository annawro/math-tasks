package org.generator.polynomial;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import pl.tasks.model.Monomial;
import pl.tasks.model.Polynomial;

public class PolynomialsGenerator {

	private static final Logger logger = Logger
			.getLogger(PolynomialsGenerator.class);

	public Polynomial createPolynomial(List<Integer> rootsOfPolynomial) {
		logger.debug("Create Polynomial beginning");

		Polynomial polynomial = new Polynomial();
		List<Monomial> factors = polynomial.getFactors();
		if (rootsOfPolynomial.size() == 0)
			return null;
		else {
			factors.add(new Monomial(1, 0));

			for (int root : rootsOfPolynomial) {
				polynomial.setFactors(this.factorsMultiply(polynomial, root));
			}
		}

		return polynomial;
	}

	public double valueOfPolynomialInPoint(Polynomial polynomial, double point) {
		double valueOfPolynomial = 0;
		for (Monomial mon : polynomial.getFactors()) {
			double valueMonInPoint = this.valueOfMonomialInPoint(point, mon);
			valueOfPolynomial += valueMonInPoint;
		}
		return valueOfPolynomial;
	}

	private List<Monomial> factorsMultiply(Polynomial polynomial, int root) {
		List<Monomial> monomials = new ArrayList<Monomial>();
		List<Monomial> factors = polynomial.getFactors();

		List<Monomial> monomialspart1 = this
				.multiplyPolinomialByMonomialX(factors);
		logger.info(monomialspart1 + " ");

		List<Monomial> monomialspart2 = this.multiplyPolinomialByRoot(factors,
				root);
		logger.info(monomialspart2 + " ");

		monomials = this.addPolynomial(monomialspart1, monomialspart2);

		logger.info(monomials + " ");
		return monomials;
	}

	private List<Monomial> multiplyPolinomialByMonomialX(List<Monomial> factors) {
		List<Monomial> monomialspart1 = new ArrayList<Monomial>();
		for (Monomial factor : factors) {
			Monomial newFactor = new Monomial(factor.getCoefficient(),
					factor.getPower() + 1);
			monomialspart1.add(newFactor);
		}
		return monomialspart1;
	}

	private List<Monomial> multiplyPolinomialByRoot(List<Monomial> factors,
			int root) {
		List<Monomial> monomialspart2 = new ArrayList<Monomial>();
		for (Monomial factor : factors) {
			Monomial newFactor = new Monomial(
					factor.getCoefficient() * (-root), factor.getPower());
			monomialspart2.add(newFactor);
		}
		return monomialspart2;
	}

	private List<Monomial> addPolynomial(List<Monomial> monomialspart1,
			List<Monomial> monomialspart2) {
		List<Monomial> monomials = new ArrayList<Monomial>();
		for (Monomial monomialTemp1 : monomialspart1) {
			Monomial monomialToRemove = null;
			for (Monomial monomialTemp2 : monomialspart2) {
				if (monomialTemp1.add(monomialTemp2)) {
					monomialToRemove = monomialTemp2;
				}
			}
			monomials.add(monomialTemp1);
			monomialspart2.remove(monomialToRemove);
			logger.info("polinomialAfterRemove: " + monomialspart2);
		}
		for (Monomial m : monomialspart2) {
			monomials.add(m);
		}
		logger.info("addPolynomial: " + monomials);
		return monomials;

	}

	private double valueOfMonomialInPoint(double point, Monomial monomial) {
		double valueInPoint;
		double value = 1;
		for (int i = 1; i < monomial.getPower() + 1; i++) {
			value = point * value;
		}
		valueInPoint = value * monomial.getCoefficient();
		return valueInPoint;
	}

}
