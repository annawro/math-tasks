package pl.tasks.model;

public class LinearFunction {
	
	private double coefficientNextToX;
	private double freeExpression;

	public LinearFunction(double a, double b) {
		this.coefficientNextToX = a;
		this.freeExpression = b;
	}

	public double getCoefficientNextToX() {
		return coefficientNextToX;
	}

	public void setCoefficientNextToX(int coefficientNextToX) {
		this.coefficientNextToX = coefficientNextToX;
	}

	public double getFreeExpression() {
		return freeExpression;
	}

	public void setFreeExpression(int freeExpression) {
		this.freeExpression = freeExpression;
	}

	public String toString() {
		if (coefficientNextToX == 0)
			return "f(x)= " + Double.toString(freeExpression);
		if (freeExpression >= 0) {
			return "f(x)= " + Double.toString(coefficientNextToX) + "*x + "
					+ Double.toString(freeExpression);
		} else
			return "f(x)= " + Double.toString(coefficientNextToX) + "*x "
					+ Double.toString(freeExpression);
	}

}
