package org.test.function.service;

import org.generator.function.LinearFunctionService;
import org.junit.Test;

public class LinearFunctionServiceTest {
	
	private LinearFunctionService lfs = new LinearFunctionService();
	
	@Test
	public void valueFunctionInPointTest(){
		//given
		double point = 6.5;
		double divisor = 2.0;
		//when
		double functionValue = lfs.valueFuncionInPoint(point, divisor);
		//then
		System.out.println("function value: " + functionValue);
	}
	

}
