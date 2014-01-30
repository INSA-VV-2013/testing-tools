package vvt.pit.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vvt.pit.code.*;

public class CalculatriceTest {
	Calculatrice c;

	@Before
	public void setUp() throws Exception {
		c = new Calculatrice();
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}
	
	@Test
	public void testFactorielle() {
		assertEquals(1, c.factorielle(0));
		assertEquals(1, c.factorielle(1));
		assertEquals(6, c.factorielle(3));
		assertEquals(120, c.factorielle(5));
	}
	
	@Test
	public void testHypotenuse() {
		assertTrue(5 == c.hypotenuse(3, 4));
		assertTrue(97 == c.hypotenuse(72, 65));
	}
	
	@Test
	public void testHypotenuseNoob() {
		assertTrue(5 == c.hypotenuseNoob(3, 4));
		assertTrue(97 == c.hypotenuseNoob(72, 65));
	}
}
