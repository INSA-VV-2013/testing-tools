package fibonacci;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class FibonacciTest extends TestCase{

	@Test
	public void testCompute() {
		int res = Fibonacci.compute(44);
		assertEquals(701408733, res);
	}

}
