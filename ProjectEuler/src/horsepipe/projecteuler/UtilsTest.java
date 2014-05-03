package horsepipe.projecteuler;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testBinomialCoefficient() {
		assertEquals(
				BigInteger.valueOf(1),
				Utils.binomialCoefficient(
						BigInteger.valueOf(0),
						BigInteger.valueOf(0)));
		assertEquals(
				BigInteger.valueOf(1),
				Utils.binomialCoefficient(
						BigInteger.valueOf(1),
						BigInteger.valueOf(0)));
		
		assertEquals(
				BigInteger.valueOf(1),
				Utils.binomialCoefficient(
						BigInteger.valueOf(1),
						BigInteger.valueOf(1)));
		
		assertEquals(
				BigInteger.valueOf(1),
				Utils.binomialCoefficient(
						BigInteger.valueOf(2),
						BigInteger.valueOf(0)));
		
		assertEquals(
				BigInteger.valueOf(2),
				Utils.binomialCoefficient(
						BigInteger.valueOf(2),
						BigInteger.valueOf(1)));
	
		assertEquals(
				BigInteger.valueOf(1),
				Utils.binomialCoefficient(
						BigInteger.valueOf(2),
						BigInteger.valueOf(2)));
		
		assertEquals(
				BigInteger.valueOf(1),
				Utils.binomialCoefficient(
						BigInteger.valueOf(3),
						BigInteger.valueOf(0)));
		
		assertEquals(
				BigInteger.valueOf(3),
				Utils.binomialCoefficient(
						BigInteger.valueOf(3),
						BigInteger.valueOf(1)));
		
		assertEquals(
				BigInteger.valueOf(3),
				Utils.binomialCoefficient(
						BigInteger.valueOf(3),
						BigInteger.valueOf(2)));
		
		assertEquals(
				BigInteger.valueOf(1),
				Utils.binomialCoefficient(
						BigInteger.valueOf(3),
						BigInteger.valueOf(3)));
		
		assertEquals(
				BigInteger.valueOf(66),
				Utils.binomialCoefficient(
						BigInteger.valueOf(12),
						BigInteger.valueOf(2)));
	}

}
