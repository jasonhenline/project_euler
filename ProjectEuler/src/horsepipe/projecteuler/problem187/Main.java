package horsepipe.projecteuler.problem187;

import horsepipe.projecteuler.factoring.PrimeFactorBase;

public class Main {
	
	private static final int N = (int) 1e8;

	public static void main(String[] args) {
		int[] base = PrimeFactorBase.getForMax(N);
		int lowerIndex = 0;
		int upperIndex = base.length - 1;
		int count = 0;
		
		while (lowerIndex < upperIndex) {
			while ((base[lowerIndex] * base[upperIndex] > N) && lowerIndex <= upperIndex) {
				upperIndex--;
			}
			
			if (lowerIndex <= upperIndex) {
				count += upperIndex - lowerIndex + 1;
			}
			
			lowerIndex++;
		}
		
		System.out.println(count);
	}

}
