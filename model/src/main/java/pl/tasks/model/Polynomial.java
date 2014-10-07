package pl.tasks.model;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {
	
	private List<Monomial> factors = new ArrayList<Monomial>();
	
	public List<Monomial> getFactors() {
		return factors;
	}

	public void setFactors(List<Monomial> factors) {
		this.factors = factors;
	}
	
	
	public String toString() {
		String polynomial = "";
		for (Monomial monTemp : factors) {
			if (monTemp.getCoefficient() > 0 && monTemp != factors.get(0)) {
				polynomial += "+";
			}
			
			if (monTemp.getCoefficient() < 0 ) {
				polynomial += "-";
			} 
			
			
			polynomial += " " + monTemp.toString() + " ";
		}
		
		return "W(x) = " + polynomial;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((factors == null) ? 0 : factors.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polynomial other = (Polynomial) obj;
		if (factors == null) {
			if (other.factors != null)
				return false;
		} else if (!factors.equals(other.factors))
			return false;
		return true;
	}

}
