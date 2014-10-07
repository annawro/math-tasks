package pl.tasks.model;

public class GeometricSequence {

	private int expression;
	private int valueOfExpression;

	public GeometricSequence(int expression, int valueOfExpression) {
		super();
		this.expression = expression;
		this.valueOfExpression = valueOfExpression;
	}

	public int getExpression() {
		return expression;
	}

	public void setExpression(int expression) {
		this.expression = expression;
	}

	public int getValueOfExpression() {
		return valueOfExpression;
	}

	public void setValueOfExpression(int valueOfExpression) {
		this.valueOfExpression = valueOfExpression;
	}

	public String toString() {
		return "b" + Integer.toString(expression) + " = "
				+ Integer.toString(valueOfExpression);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + expression;
		result = prime * result + valueOfExpression;
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
		GeometricSequence other = (GeometricSequence) obj;
		if (expression != other.expression)
			return false;
		if (valueOfExpression != other.valueOfExpression)
			return false;
		return true;
	}
	

}
