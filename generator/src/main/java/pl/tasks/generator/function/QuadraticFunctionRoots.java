package pl.tasks.generator.function;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class QuadraticFunctionRoots {

	private Logger logger = Logger.getLogger(QuadraticFunctionRoots.class);

	private double delta(double a, double b, double c) {
		return b * b - 4 * a * c;
	}

	public List<Double> quadraticFunctionRoots(double a, double b, double c) {
		List<Double> quadraticRoots = new ArrayList<Double>();
		double delta = this.delta(a, b, c);
		if (delta >= 0) {
			double root1 = (-b - Math.sqrt(delta)) / 2 * a;

			double root2 = (-b + Math.sqrt(delta)) / 2 * a;

			quadraticRoots.add(root1);

			if (delta > 0) {
				quadraticRoots.add(root2);
			}
		}
		logger.info("delta : " + delta);
		logger.info("pierwiastki: " + quadraticRoots);
		return quadraticRoots;
	}
}
