package pl.tasks.generator.function;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import pl.tasks.generator.function.QuadraticFunctionRoots;

public class QuadraticFunctionRootsTest {
	private QuadraticFunctionRoots quadraticFunctionRoots = new QuadraticFunctionRoots();

	@Test
	public void quadtaricFunctionRootsTest() {
		double a = 1.0, b = 4.0, c = 4.0;
		List<Double> roots = quadraticFunctionRoots.quadraticFunctionRoots(a, b, c);
		assertEquals(1,roots.size());
	}

}
