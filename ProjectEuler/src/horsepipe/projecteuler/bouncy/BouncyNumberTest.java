package horsepipe.projecteuler.bouncy;

import static org.junit.Assert.*;

import org.junit.Test;

public class BouncyNumberTest {

	@Test
	public void testIsBouncy() {
		int[] bouncy = {121, 212, 12121};
		int[] notBouncy = {0, 1, 12, 21, 111, 122, 112, 221, 211, 11223, 32211};
		
		for (int n : bouncy) {
			assertTrue(BouncyNumber.isBouncy(n));
		}
		
		for (int n : notBouncy) {
			assertFalse(BouncyNumber.isBouncy(n));
		}
	}

}
