package horsepipe.projecteuler.factoring;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;

public class TrialDivisionFactorerTest {

	@Test
	public void testFactor() {
		Factorer factorer = new TrialDivisionFactorer();
		TreeMap<Long, Long> factors = null;
		TreeMap<Long, Long> expected = null;
		
		factors = factorer.factor(1L);
		expected = new TreeMap<Long, Long>();
		assertEquals(expected, factors);
		
		factors = factorer.factor(2L);
		expected = new TreeMap<Long, Long>();
		expected.put(2L, 1L);
		assertEquals(expected, factors);
		
		factors = factorer.factor(3L);
		expected = new TreeMap<Long, Long>();
		expected.put(3L, 1L);
		assertEquals(expected, factors);
	
		factors = factorer.factor(4L);
		expected = new TreeMap<Long, Long>();
		expected.put(2L, 2L);
		assertEquals(expected, factors);
		
		factors = factorer.factor(5L);
		expected = new TreeMap<Long, Long>();
		expected.put(5L, 1L);
		assertEquals(expected, factors);
		
		factors = factorer.factor(6L);
		expected = new TreeMap<Long, Long>();
		expected.put(2L, 1L);
		expected.put(3L, 1L);
		assertEquals(expected, factors);
		
		factors = factorer.factor(7L);
		expected = new TreeMap<Long, Long>();
		expected.put(7L, 1L);
		assertEquals(expected, factors);
		
		factors = factorer.factor(8L);
		expected = new TreeMap<Long, Long>();
		expected.put(2L, 3L);
		assertEquals(expected, factors);
		
		factors = factorer.factor(9L);
		expected = new TreeMap<Long, Long>();
		expected.put(3L, 2L);
		assertEquals(expected, factors);
	
		factors = factorer.factor(10L);
		expected = new TreeMap<Long, Long>();
		expected.put(2L, 1L);
		expected.put(5L, 1L);
		assertEquals(expected, factors);
	
		factors = factorer.factor(11L);
		expected = new TreeMap<Long, Long>();
		expected.put(11L, 1L);
		assertEquals(expected, factors);

		factors = factorer.factor(12L);
		expected = new TreeMap<Long, Long>();
		expected.put(2L, 2L);
		expected.put(3L, 1L);
		assertEquals(expected, factors);
	}

}
