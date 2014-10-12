package pl.tasks.generator.sequences;

import static org.junit.Assert.*;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.Test;

import pl.tasks.generator.polynomial.RootsGenerator;
import pl.tasks.generator.sequences.ArithmeticSequencesGenerator;
import pl.tasks.model.ArithmeticSequence;

import com.google.common.collect.Lists;

public class ArithmeticSequencesGeneratorTest {

	private ArithmeticSequencesGenerator asg = new ArithmeticSequencesGenerator();

	@Test
	public void valueOfArithmeticSequenceTest() {
		// given
		int n = 5;
		int quantityOfRoots = 2;
		int range = 10;
		RootsGenerator generator = EasyMock.createMock(RootsGenerator.class);
		EasyMock.expect(generator.rootsOfPolynomial(quantityOfRoots, range))
				.andReturn(Lists.newArrayList(5,3));
		EasyMock.replay(generator);
		asg.setGenerator(generator);
		// when
		List<ArithmeticSequence> valueOfAS = asg.valuesOfArithmeticSequence(n);
		String sequence = asg.toString();
		System.out.println(sequence);
		// then
		assertEquals(new ArithmeticSequence(1, 5),valueOfAS.get(0));
		assertEquals(new ArithmeticSequence(2, 8),valueOfAS.get(1));
		assertEquals(new ArithmeticSequence(3, 11),valueOfAS.get(2));
		assertEquals(new ArithmeticSequence(4, 14),valueOfAS.get(3));
		assertEquals(new ArithmeticSequence(5, 17),valueOfAS.get(4));
	}
}
