package kr.or.nextit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testSum() {
		double result = Calculator.sum(4, 5);
		assertTrue("9가 나와야 한다는 말이다", result == 9);
	}

	@Test
	public void testSubstract() {
		double result = Calculator.substract(7, 5);
		assertTrue("2가 나와야 한다는 말이다", result == 2);

	}

	@Test
	public void testMultiply() {
		double result = Calculator.multiply(4, 5);
		assertTrue("20가 나와야 한다는 말이다", result == 20);
	}

	@Test
	public void testDevide() {
		double result = Calculator.devide(16, 4);
		assertTrue("4가 나와야 한다는 말이다", result == 4);

	}

}
