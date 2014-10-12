package pl.tasks.web;

import java.util.List;

import pl.tasks.model.Polynomial;

public class PolynomialWithRoots {

	private Polynomial polynomial;
	private List<Integer> rootsOfPolynomial;
	
	public PolynomialWithRoots(Polynomial polynomial,
			List<Integer> rootsOfPolynomial) {
		super();
		this.polynomial = polynomial;
		this.rootsOfPolynomial = rootsOfPolynomial;
	}

	public Polynomial getPolynomial() {
		return polynomial;
	}

	public List<Integer> getRootsOfPolynomial() {
		return rootsOfPolynomial;
	}
	
}
