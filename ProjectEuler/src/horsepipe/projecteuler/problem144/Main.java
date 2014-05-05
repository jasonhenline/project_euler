package horsepipe.projecteuler.problem144;

public class Main {

	public static void main(String[] args) {
		double x = 1.4;
		double y = -9.6;
		double m = (10.1 + 9.6) / (0.0 - 1.4);
		double b = intercept(x, y, m);

		System.out.println("m = " + m);
		System.out.println("b = " + b);
		System.out.println(x + ", " + y);
		System.out.println("");
		
		int bounces = 0;

		while (x < -0.01 || x > 0.01 || y < 0) {
			m = newSlope(x, y, m);
			b = intercept(x, y, m);
			x = newX(x, b, m);
			y = newY(x, b, m);
			bounces++;

			System.out.println("m = " + m);
			System.out.println("b = " + b);
			System.out.println(x + ", " + y);
			System.out.println("bounces = " + bounces);
			System.out.println("");
		}
	}

	public static double normalSlope(double x, double y) {
		return y / (4.0 * x);
	}

	public static double newSlope(double x, double y, double m) {
		double a = normalSlope(x, y);
		System.out.println("a = " + a);
		System.out.println("m = " + m);
		return (m*a*a - m + 2.0*a) / (1.0 + 2.0*a*m - a*a);
	}

	public static double intercept(double x, double y, double m) {
		return y - (m * x);
	}

	public static double newX(double x, double b, double m) {
		return ((-x * (m * m + 4)) - (2 * m * b)) / ((m * m) + 4.0);
	}

	public static double newY(double x, double b, double m) {
		return (m * x) + b;
	}

}
