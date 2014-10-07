package org.test.sequences.generator;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.easymock.EasyMock;
import org.generator.polynomial.RootsGenerator;
import org.generator.sequences.GeometricSequencesGenerator;
import org.junit.Test;

import pl.tasks.model.GeometricSequence;

import com.google.common.collect.Lists;

public class GeometicSequencesGeneratorTest {

	private GeometricSequencesGenerator gsg = new GeometricSequencesGenerator();

	@Test
	public void valuesOfExpressionGeometricSequenceTest() {
		// given
		int n = 4;
		RootsGenerator generator = EasyMock.createMock(RootsGenerator.class);
		EasyMock.expect(generator.rootsOfPolynomial(2, 20)).andReturn(
				Lists.newArrayList(7, 2));
		EasyMock.replay(generator);
		// when
		gsg.setRootsGenerator(generator);
		List<GeometricSequence> valuesOfExpressionGS = gsg
				.valuesOfExpressionGeometricSequence(n);
		String sequence = gsg.toString();
		System.out.println(sequence);
		assertEquals(new GeometricSequence(1, 7), valuesOfExpressionGS.get(0));
		assertEquals(new GeometricSequence(2, 14), valuesOfExpressionGS.get(1));
		assertEquals(new GeometricSequence(3, 28), valuesOfExpressionGS.get(2));
		assertEquals(new GeometricSequence(4, 56), valuesOfExpressionGS.get(3));
	}
}
