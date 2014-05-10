package horsepipe.projecteuler.problem122;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class ChainIteratorTest {

	@Test
	public void testHasNext() {
		checkChain(1, new int[] {1});
		checkChain(2, new int[] {2});
		checkChain(3, new int[] {3, 4});
		checkChain(4, new int[] {4, 4, 5, 6, 5, 6, 8});
	}
	
	private void checkChain(int length, int[] expected) {
		Iterator<Integer> iterator = new ChainIterator(length);
		for (int i = 0; i < expected.length; i++) {
			assertTrue(iterator.hasNext());
			assertEquals("At expected index " + i, expected[i], (int) iterator.next());
		}
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testTime() {
		Iterator<Integer> iterator = new ChainIterator(11);
		while(iterator.hasNext()) {
			iterator.next();
		}
	}

}
