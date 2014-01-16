package vvt.pit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import vvt.pit.code.FirstClass;

public class FirstTest {
	@Test
	public void testFirtClass() {
		boolean test= new FirstClass(false).isMyBool();
		assertFalse(test);
		
	}

}
