package org.test.function.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.generator.function.QuadraticFunctionRoots;
import org.junit.Test;

public class QuadraticFunctionRootsTest {
	private QuadraticFunctionRoots quadraticFunctionRoots = new QuadraticFunctionRoots();

	@Test
	public void quadtaricFunctionRootsTest() {
		double a = 1.0, b = 4.0, c = 4.0;
		List<Double> roots = quadraticFunctionRoots.quadraticFunctionRoots(a, b, c);
		assertEquals(1,roots.size());
	}

}
