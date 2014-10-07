package pl.tasks.model;

public class ArithmeticSequence {

	private int expression;
	private int valueOfExpression;

	public ArithmeticSequence(int expression, int valueOfExpression) {
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
		return "a" + expression + " = " + Integer.toString(valueOfExpression);
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
		ArithmeticSequence other = (ArithmeticSequence) obj;
		if (expression != other.expression)
			return false;
		if (valueOfExpression != other.valueOfExpression)
			return false;
		return true;
	}
	
}
