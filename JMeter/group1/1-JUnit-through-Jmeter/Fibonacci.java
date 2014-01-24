package fibonacci;

public class Fibonacci {

	public static int compute(int a) {
		if (a == 0)
			return 0;
		if (a == 1)
			return 1;
		return Fibonacci.compute(a - 1) + Fibonacci.compute(a - 2);
	}

}
