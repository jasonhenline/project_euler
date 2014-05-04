package horsepipe.projecteuler.problem121;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static final int N = 15;

	public static void main(String[] args) {
		List<Double> probsForLastStep = new ArrayList<Double>();
		probsForLastStep.add(1.0);
		
		for (int s = 1; s <= N; s++) {
			List<Double> probsForThisStep = new ArrayList<Double>();
			Double probOfBlue = 1.0 / (1.0 + s);
			Double probOfRed = 1.0 - probOfBlue;
			probsForThisStep.add(probsForLastStep.get(0) * probOfRed);
			for (int b = 1; b < s; b++) {
				Double probForThisBlueCount =
						(probsForLastStep.get(b - 1) * probOfBlue)
						+ (probsForLastStep.get(b) * probOfRed);
				probsForThisStep.add(probForThisBlueCount);
			}
			probsForThisStep.add(probOfBlue * probsForLastStep.get(s - 1));
			probsForLastStep = new ArrayList<Double>();
			for (double p : probsForThisStep) {
				probsForLastStep.add(p);
			}
		}
		
		Double probWin = 0.0;
		for (int b = N/2 + 1; b <= N; b++) {
			probWin += probsForLastStep.get(b);
		}
		
		System.out.println((int) Math.floor(1.0/probWin));
	}

}
