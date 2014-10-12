package pl.tasks.generator.polynomial;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import pl.tasks.generator.polynomial.PolynomialsGenerator;
import pl.tasks.model.Monomial;
import pl.tasks.model.Polynomial;

import com.google.common.collect.Lists;

public class PolynomialTest {

	private PolynomialsGenerator polynomialsGenerator = new PolynomialsGenerator();
	private Monomial monomial = new Monomial(2, 2);

	@Test
	public void createPolynomialTest() {
		// given
		List<Integer> rootsOfPolynomial = Lists.newArrayList(5, 1, 2);
		// when
		Polynomial polynomial = polynomialsGenerator
				.createPolynomial(rootsOfPolynomial);

		// then
		assertEquals(4, polynomial.getFactors().size());
		assertEquals(new Monomial(1, 3), polynomial.getFactors().get(0));
		assertEquals(new Monomial(-8, 2), polynomial.getFactors().get(1));
		assertEquals(new Monomial(17, 1), polynomial.getFactors().get(2));
		assertEquals(new Monomial(-10, 0), polynomial.getFactors().get(3));
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
	}

	@Test
	public void addMonomialTest() {
		Monomial mon1 = new Monomial(5, 2);
		monomial.add(mon1);
		System.out.println(monomial.toString());
		assertEquals(7, monomial.getCoefficient());
		System.out.println("!!!!!!!");
	}

	@Test
	public void valuePolynomialInPointTest() {
		double point = -1.0;
		List<Integer> rootsOfPolynomial = Lists.newArrayList(5, 1, 2);
		// when
		Polynomial polynomial = polynomialsGenerator
				.createPolynomial(rootsOfPolynomial);

		System.out.println(polynomialsGenerator.valueOfPolynomialInPoint(
				polynomial, point));
		assertEquals(4, polynomial.getFactors().size());
	}

}
