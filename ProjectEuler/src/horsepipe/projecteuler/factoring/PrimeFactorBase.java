package horsepipe.projecteuler.factoring;

import java.util.BitSet;

public class PrimeFactorBase {
	
	public static int[] getForMax(int max) {
		BitSet isComposite = new BitSet(max + 1);
		for (int i = 2; i * i <= max; i++) {
			if (!isComposite.get(i)) {
				for (int j = i; i * j <= max; j++) {
					isComposite.set(i * j);
				}
			}
		}
		int numberOfPrimes = 0;
		for (int i = 2; i <= max; i++) {
			if (!isComposite.get(i)) {
				numberOfPrimes++;
			}
		}
		int[] primes = new int[numberOfPrimes];
		int index = 0;
		for (int i = 2; i <= max; i++) {
			if (!isComposite.get(i)) {
				primes[index] = i;
				index++;
			}
		}
		return primes;
	}
	
}
