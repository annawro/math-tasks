package pl.tasks.generator.sequences;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.Ignore;
import org.junit.Test;

import pl.tasks.generator.polynomial.RootsGenerator;
import pl.tasks.generator.sequences.ArithmeticSequencesGenerator;
import pl.tasks.generator.sequences.GeometricSequencesGenerator;
import pl.tasks.generator.sequences.SequencesService;
import pl.tasks.model.ArithmeticSequence;
import pl.tasks.model.GeometricSequence;

import com.google.common.collect.Lists;

@Ignore
public class SequencesServiceTest {

	private SequencesService sequencesService = new SequencesService();

	@Test
	public void sumOfArithmeticSequenceTest() {
		// given
		int n = 6;
		RootsGenerator generator = EasyMock.createMock(RootsGenerator.class);
		EasyMock.expect(generator.rootsOfPolynomial(2, 10))
				.andReturn(Lists.newArrayList(5,3));
		EasyMock.replay(generator);
		ArithmeticSequencesGenerator arithmeticSequence = new ArithmeticSequencesGenerator();
		arithmeticSequence.setGenerator(generator);
		List<ArithmeticSequence> generateSequence = arithmeticSequence
				.valuesOfArithmeticSequence(n);
		// when
		int sum1 = sequencesService.sumOfArithmeticSequence(generateSequence);
		System.out.print(sum1 + " ");
		int sum2 = sequencesService
				.sumOfArithmeticSequenceSimply(generateSequence);
		System.out.println(sum2);
		// then
		assertEquals(sum1, sum2);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
	
	@Test
	public void sumOfGeometricSequenceTest() {
		// given
		int n = 3;
		RootsGenerator generator = EasyMock.createMock(RootsGenerator.class);
		EasyMock.expect(generator.rootsOfPolynomial(2, 20)).andReturn(
				Lists.newArrayList(7, 2));
		EasyMock.replay(generator);
		// when
		GeometricSequencesGenerator geometricSequence = new GeometricSequencesGenerator();
		geometricSequence.setRootsGenerator(generator);
		List<GeometricSequence> generateSequence = geometricSequence.valuesOfExpressionGeometricSequence(n);
		int sum2 = sequencesService
				.sumOfGeometricSequenceSimply(generateSequence);
		System.out.println(sum2);
		// then
		assertEquals(49, sum2);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
}
