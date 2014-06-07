package horsepipe.projecteuler.problem145;

public class Main {
	
	static int reverse(int n) {
		int result = 0;
		while (n > 0) {
			result *= 10;
			result += (n % 10);
			n /= 10;

		}
		return result;
	}
	
	static boolean digitsAllOdd(int n) {
		while (n > 0) {
			if ((n % 10) % 2 == 0) {
				return false;
			}
			n /= 10;
		}
		return true;
	}
	
	static boolean isReversible(int n) {
		if (n % 10 == 0) {
			return false;
		}
		return digitsAllOdd(n + reverse(n));
	}

	public static void main(String[] args) {
		int count = 0;
		for (int i = 0; i < (int)1e9; i++) {
			if (isReversible(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

}
