

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestA1 {

	ObjetA a;
	@Before
	public void setUp() throws Exception {
		a = new ObjetA(5,10);
	}

	@Test
	public void test() {
		assertEquals(a.getB(),10);
	}

}
