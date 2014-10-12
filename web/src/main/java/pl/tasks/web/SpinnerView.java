package pl.tasks.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.generator.polynomial.PolynomialsGenerator;
import org.generator.polynomial.RootsGenerator;

import pl.tasks.model.Polynomial;

@ManagedBean
@ViewScoped
public class SpinnerView {

	private static final int RANGE = 3;
	private int degree;
	private PolynomialsGenerator polynomialGenerator = new PolynomialsGenerator();
	private RootsGenerator rootsGenerator = new RootsGenerator();
	private Polynomial polynomial = new Polynomial();
	private List<Integer> rootsOfPolynomial = new ArrayList<Integer>();
	private PolynomialWithRoots polynomialWithRoots = new PolynomialWithRoots(new Polynomial(), new ArrayList<Integer>());
	
	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
		rootsOfPolynomial = rootsGenerator.rootsOfPolynomial(degree, RANGE);
		polynomial = polynomialGenerator.createPolynomial(rootsOfPolynomial);
		polynomialWithRoots = new PolynomialWithRoots(polynomial,rootsOfPolynomial);
		
	}

	public void setPolynomial(Polynomial polynomial) {
		this.polynomial = polynomial;
	}

	public Polynomial getPolynomial() {
		return polynomial;

	}
	
	public PolynomialWithRoots getPolynomialWithRoots() {
		return polynomialWithRoots;
	}

	public List<Integer> getRootsOfPolynomial() {
		return rootsOfPolynomial;
	}

}
