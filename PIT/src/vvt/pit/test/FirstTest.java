package vvt.pit.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vvt.pit.code.FirstClass;

public class FirstTest {

	FirstClass c;
	
	@Before
	public void init() {
		c = new FirstClass();
	}
	
	@After
	public void TearDown(){
		c = null;
	}

	@Test
	public void testFirtClass() {
		c.setMyBool(false);
		boolean test = c.isMyBool();
		assertFalse(test);

	}
	
	@Test
	public void testCmpt(){
		c.setCmpt(10);
		assertEquals(11, c.getCmpt());
	}

}
