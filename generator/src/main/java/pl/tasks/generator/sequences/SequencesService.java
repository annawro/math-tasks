package pl.tasks.generator.sequences;

import java.util.List;

import pl.tasks.model.ArithmeticSequence;
import pl.tasks.model.GeometricSequence;

public class SequencesService {

	public int sumOfArithmeticSequence(
			List<ArithmeticSequence> arithmeticSequence) {
		int n = arithmeticSequence.size();
		int sumOfArithmeticSequence = n
				* (arithmeticSequence.get(0).getValueOfExpression() + arithmeticSequence
						.get(n - 1).getValueOfExpression()) / 2;
		return sumOfArithmeticSequence;
	}

	public int sumOfArithmeticSequenceSimply(
			List<ArithmeticSequence> arithmeticSequence) {
		int sumOfArithmeticSequence = 0;
		for (ArithmeticSequence sequenceTemp : arithmeticSequence) {
			sumOfArithmeticSequence += sequenceTemp.getValueOfExpression();
		}
		return sumOfArithmeticSequence;
	}

	public int sumOfGeometricSequenceSimply(
			List<GeometricSequence> geometricSequence) {
		int sumOfGeometricSequence = 0;
		for (GeometricSequence sequenceTemp : geometricSequence) {
			sumOfGeometricSequence += sequenceTemp.getValueOfExpression();
		}
		return sumOfGeometricSequence;
	}
}
