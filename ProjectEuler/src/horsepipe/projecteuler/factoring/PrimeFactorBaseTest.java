package horsepipe.projecteuler.factoring;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeFactorBaseTest {

	@Test
	public void testGetForMax() {
		int[] base;
		base = PrimeFactorBase.getForMax(2);
		assertArrayEquals(new int[] {2}, base);
		
		base = PrimeFactorBase.getForMax(3);
		assertArrayEquals(new int[] {2, 3}, base);
		
		base = PrimeFactorBase.getForMax(4);
		assertArrayEquals(new int[] {2, 3}, base);
		
		base = PrimeFactorBase.getForMax(5);
		assertArrayEquals(new int[] {2, 3, 5}, base);
		
		base = PrimeFactorBase.getForMax(100);
		assertArrayEquals(new int[] {
				 2,  3,  5,  7, 11,
				13, 17, 19, 23, 29,
				31, 37, 41, 43, 47,
				53, 59, 61, 67, 71,
				73, 79, 83, 89, 97},
				base);
	}

}
