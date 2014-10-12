package pl.tasks.generator.polynomial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class RootsGenerator {
	
	private static final Logger logger = Logger.getLogger(RootsGenerator.class);
	private Random rootsGenerator = new Random();
	
	public List<Integer> rootsOfPolynomial(int quantityOfRoots, int range) {
		List<Integer> rootsOfPolynomial = new ArrayList<Integer>();
		for (int i = 0; i < quantityOfRoots; i++) {
			rootsOfPolynomial.add(rootsGenerator.nextInt(2*range) - range);
		}
		logger.info("root: " + rootsOfPolynomial + " ");
		return rootsOfPolynomial;
	}

}
