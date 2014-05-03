package horsepipe.projecteuler;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

public class SubsetIteratorTest {

	@Test
	public void testSubsetIterator3choose2() {
		Iterator<int[]> iterator =  new SubsetIterator(3, 2);
		int[][] expected = {
				{0, 1},
				{0, 2},
				{1, 2}};
		for (int[] e : expected) {
			assertTrue(iterator.hasNext());
			assertTrue(Arrays.equals(e, iterator.next()));
		}
		assertFalse(iterator.hasNext());
	}
	
	public void testSubsetIterator4choose2() {
		Iterator<int[]> iterator =  new SubsetIterator(4, 2);
		int[][] expected = {
				{0, 1},
				{0, 2},
				{0, 3},
				{1, 2},
				{1, 3},
				{2, 3}};
		for (int[] e : expected) {
			assertTrue(iterator.hasNext());
			assertTrue(Arrays.equals(e, iterator.next()));
		}
		assertFalse(iterator.hasNext());
	}
	
	public void testSubsetIterator5choose3() {
		Iterator<int[]> iterator =  new SubsetIterator(5, 3);
		int[][] expected = {
				{0, 1, 2},
				{0, 1, 3},
				{0, 1, 4},
				{0, 2, 3},
				{0, 2, 4},
				{0, 3, 4},
				{1, 2, 3},
				{1, 2, 4},
				{1, 3, 4},
				{2, 3, 4}};
		for (int[] e : expected) {
			assertTrue(iterator.hasNext());
			assertTrue(Arrays.equals(e, iterator.next()));
		}
		assertFalse(iterator.hasNext());
	}
	
	public void testSubsetIterator6choose3() {
		Iterator<int[]> iterator =  new SubsetIterator(6, 3);
		int[][] expected = {
				{0, 1, 2},
				{0, 1, 3},
				{0, 1, 4},
				{0, 1, 5},
				{0, 2, 3},
				{0, 2, 4},
				{0, 2, 5},
				{0, 3, 4},
				{0, 3, 5},
				{1, 2, 3},
				{1, 2, 4},
				{1, 2, 5},
				{1, 3, 4},
				{1, 3, 5},
				{2, 3, 4},
				{2, 3, 5},
				{3, 4, 5}};
		for (int[] e : expected) {
			assertTrue(iterator.hasNext());
			assertTrue(Arrays.equals(e, iterator.next()));
		}
		assertFalse(iterator.hasNext());
	}

}
