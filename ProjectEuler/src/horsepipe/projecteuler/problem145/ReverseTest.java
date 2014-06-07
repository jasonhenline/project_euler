package horsepipe.projecteuler.problem145;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseTest {

	@Test
	public void testReverse() {
		int[][] reversed = {
				{0, 0},
				{1, 1},
				{2, 2},
				{3, 3},
				{9, 9},
				{10, 1},
				{11, 11},
				{12, 21},
				{98, 89},
				{99, 99},
				{100, 1},
				{101, 101},
				{102, 201},
				{123, 321}
		};
		
		for (int[] r : reversed) {
			assertEquals(r[1], Main.reverse(r[0]));
		}
	}
	
	@Test
	public void testIsReversible() {
		int[] reversible = {36, 63, 409, 904};
		int[] notReversible = {1, 2, 3, 11};
		
		for (int r: reversible) {
			assertTrue(Main.isReversible(r));
		}
		
		for (int n: notReversible) {
			assertFalse(Main.isReversible(n));
		}
	}

}
