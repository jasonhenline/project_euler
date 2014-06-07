package horsepipe.projecteuler.bouncy;

public class BouncyNumber {
	
	public static boolean isBouncy(int n) {
		if (n < 100) {
			return false;
		}
		boolean rises = false;
		boolean falls = false;
		int last = n % 10;
		n /= 10;
		while (n > 0) {
			int next = n % 10;
			if (next > last) {
				if (falls) {
					return true;
				} else {
					rises = true;
				}
			} else if (next < last) {
				if (rises) {
					return true;
				} else {
					falls = true;
				}
			}
			n /= 10;
			last = next;
		}
		return false;
	}

}
