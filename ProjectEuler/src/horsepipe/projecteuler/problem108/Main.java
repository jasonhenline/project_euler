package horsepipe.projecteuler.problem108;

public class Main {
	static final int GOAL = 1000;

	public static void main(String[] args) {
		int n = 1;
		int max = 0;
		int maxarg = 0;
		while (true) {
			int sols = numberOfSolutions(n);
			if (sols > max) {
				max = sols;
				maxarg = n;
			}
			System.out.println(Integer.toString(n) + ": " + max + ": " + maxarg + ": " + sols);
			if (sols > GOAL) {
				System.out.println(n);
				break;
			}
			n++;
		}
	}

	/**
	 * Assumes x > n.
	 */
	static boolean hasSolution(int x, int n) {
		int numerator = n * x;
		int denominator = x - n;
		int remainder = numerator % denominator;
		int y = numerator / denominator;
		return (remainder == 0) && (y <= x);
	}

	static int numberOfSolutions(int n) {
		int count = 0;
		for (int x = n + 1; x <= n * n + n; x++) {
			if (hasSolution(x, n)) {
				count++;
			}
		}
		return count;
	}

}
