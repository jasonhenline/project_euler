package horsepipe.projecteuler.problem106;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void testCouldNotBeEqual() {
		boolean[][] cannotBeEqual = {
				{true, false},
				{false, true},
				{true, false, true, false},
				{true, true, false, false},
				{false, false, true, true},
				{true, true, false, false, true, false}
		};
		for (boolean[] inSet : cannotBeEqual) {
			assertFalse(Main.couldBeEqual(inSet));
		}
	}
	
	@Test
	public void testCouldBeEqual() {
		boolean[][] canBeEqual = {
				{true, false, false, true},
				{false, true, true, false},
				{true, false, false, true, true, false},
				{true, false, false, true, false, true},
				{true, true, false, false, false, true}
		};
		for (boolean[] inSet : canBeEqual) {
			assertTrue(Main.couldBeEqual(inSet));
		}
	}

}
