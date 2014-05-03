package horsepipe.projecteuler;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrayCoderTest {

	@Test
	public void testGrayCoder() {
		GrayCoder coder = new GrayCoder(0);
		assertEquals(0, coder.getPattern());
		assertFalse(coder.hasNext());
		
		coder = new GrayCoder(1);
		assertEquals(0, coder.getPattern());
		assertTrue(coder.hasNext());
		GrayCodeStep step = coder.next();
		assertEquals(1, coder.getPattern());
		assertTrue(step.getIsTurnOn());
		assertEquals(0, step.getPosition());
		assertFalse(coder.hasNext());
		
		coder = new GrayCoder(2);
		assertEquals(0, coder.getPattern());
		assertTrue(coder.hasNext());
		step = coder.next();
		assertEquals(1, coder.getPattern());
		assertTrue(step.getIsTurnOn());
		assertEquals(0, step.getPosition());
		assertTrue(coder.hasNext());
		step = coder.next();
		assertEquals(3, coder.getPattern());
		assertTrue(step.getIsTurnOn());
		assertEquals(1, step.getPosition());
		assertTrue(coder.hasNext());
		step = coder.next();
		assertEquals(2, coder.getPattern());
		assertFalse(step.getIsTurnOn());
		assertEquals(0, step.getPosition());
		assertFalse(coder.hasNext());
	}

}
