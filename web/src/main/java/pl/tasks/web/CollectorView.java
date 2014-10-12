package pl.tasks.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.google.common.collect.Lists;

import pl.tasks.model.Polynomial;

@ManagedBean
@ViewScoped
public class CollectorView implements Serializable {

	private PolynomialWithRoots polynomialWithRoots;
	private List<PolynomialWithRoots> polynomialsWithRoots;

	@ManagedProperty(value = "#{spinnerView}")
	private SpinnerView spinnerView;

	@PostConstruct
	public void init() {
		polynomialsWithRoots = new ArrayList<PolynomialWithRoots>();
		polynomialWithRoots = new PolynomialWithRoots(new Polynomial(), new ArrayList<Integer>());

	}

	public String reinit() {
		Polynomial polynomial = spinnerView.getPolynomial();
		List<Integer> rootsOfPolynomial = spinnerView.getRootsOfPolynomial();
		polynomialWithRoots = new PolynomialWithRoots(polynomial, rootsOfPolynomial); 
		return null;
	}

	public List<PolynomialWithRoots> getPolynomialsWithRoots() {
		return polynomialsWithRoots;
	}
	
	public PolynomialWithRoots getPolynomialWithRoots() {
		return polynomialWithRoots;
	}

	public SpinnerView getSpinnerView() {
		return spinnerView;
	}

	public void setSpinnerView(SpinnerView spinnerView) {
		this.spinnerView = spinnerView;
	}

	

}
