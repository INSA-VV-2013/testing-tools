package vvt.pit.code;

public class Calculatrice {
	
	private int quarantedeux;
	
	public Calculatrice() {
		this.quarantedeux = 42;
	}
	
	public int retourne42() {
		return this.quarantedeux;
	}
	
	public int negatif(int nb) {
		return -nb;
	}
	
	public double hypotenuse(double a, double b) {
		double h = a*a+b*b;
		return Math.sqrt(h);
	}
	
	public double hypotenuseNoob(double a, double b) {
		double h = a*a+b*b;
		if(h >= 0) {
			return Math.sqrt(h);
		} else {
			throw new RuntimeException("doesn't work !");
		}
	}
	
	public int factorielle(int nb) {
		if(nb == 0 || nb == 1) {
			return 1;
		} else {
			return factorielle(nb-1)*nb;
		}
	}
}
