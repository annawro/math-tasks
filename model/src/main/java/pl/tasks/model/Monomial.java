package pl.tasks.model;

public class Monomial {

	private int coefficient;
	private int power;

	public Monomial(int coefficient, int power) {
		super();
		this.coefficient = coefficient;
		this.power = power;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean add(Monomial mon1) {
		if (this.power == mon1.getPower()) {
			this.coefficient += mon1.getCoefficient();
			return true;
		}
		return false;
	}

	public String toString() {
		if (coefficient != 0) {
			return getBase() + getExponent();

		}
		return "";
	}

	private String getBase() {
		if (power == 0) {
			return Math.abs(coefficient) + " ";
		}
		if (Math.abs(coefficient) == 1) {
			return "x";
		}
		return Math.abs(coefficient) + "x";
	}

	private String getExponent() {
		if (power > 1) {
			return "<sup>" + power + "</sup>";
		}
		return "";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monomial other = (Monomial) obj;
		if (coefficient != other.coefficient)
			return false;
		if (power != other.power)
			return false;
		return true;
	}
	

}
