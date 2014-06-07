package horsepipe.projecteuler.problem112;

import horsepipe.projecteuler.bouncy.BouncyNumber;

public class Main {
	
	public static void main(String[] args) {
		final int TARGET_PERCENTAGE = 99;
		
		int bouncyUpToHere = 0;
		for (int i = 100; true; i++) {
			if (BouncyNumber.isBouncy(i)) {
				bouncyUpToHere++;
			}
			int comparison = (100 * bouncyUpToHere) - (TARGET_PERCENTAGE * i);
			if (comparison >= 0) {
				System.out.println(i);
				break;
			}
		}
	}

}
