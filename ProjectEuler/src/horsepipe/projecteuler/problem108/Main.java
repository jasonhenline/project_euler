package horsepipe.projecteuler.problem108;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import horsepipe.projecteuler.GrayCodeStep;
import horsepipe.projecteuler.GrayCoder;
import horsepipe.projecteuler.factoring.Factorer;
import horsepipe.projecteuler.factoring.TrialDivisionFactorer;

public class Main {
	static final int GOAL = 1000;

	public static void main(String[] args) {
		Main main = new Main();
		int n = 1;
		int max = 0;
		int maxarg = 0;
		while (true) {
			int sols = main.numberOfSolutions(n);
			if (sols > max) {
				max = sols;
				maxarg = n;
			}
			System.out.println(maxarg + ": " + max + ": " + Integer.toString(n) + ": " + sols);
			if (sols > GOAL) {
				System.out.println(n);
				break;
			}
			n++;
		}
	}
	
	private Factorer factorer;
	
	private Main() {
		this.factorer = new TrialDivisionFactorer();
	}

	int numberOfSolutions(int n) {
		/*
		 * Solutions are of the form:
		 * 	x = m*(a + b)*a
		 * 	y = m*(a + b)*b
		 * 	n = a*b
		 * where gcd(a,b) = 1
		 */
		TreeMap<Long, Long> factors = factorer.factor(n);
		List<Long> multiplicities = new ArrayList<Long>(factors.values());

		// Start with none of the factors in <em>a</em>.
		int aFactor = 1;
		int bFactor = 1;
		for (Long m : multiplicities) {
			bFactor *= (m + 1);
		}
		int count = aFactor * bFactor;
		
		GrayCoder grayCoder = new GrayCoder(multiplicities.size());
		while (grayCoder.hasNext()) {
			GrayCodeStep next = grayCoder.next();
			int position = next.getPosition();
			long multiplicity = multiplicities.get(position);
			if (next.getIsTurnOn()) {
				aFactor *= multiplicity;
				bFactor /= multiplicity + 1;
			} else {
				aFactor /= multiplicity;
				bFactor *= multiplicity + 1;
			}
			count += aFactor * bFactor;
		}
		
		// TODO Loop through combinations where <em>a</em> has some factors.
		// TODO aFactor is product of <em>m</em> for multiplicities in <em>a</em>.
		// TODO bFactor is product of <em>(m + 1)</em> for multiplicities in <em>b</em>.
		// TODO Use Gray code stepping.
		// TODO If a position is added in, multiply aFactor by m and divide bFactor by m + 1.
		// TODO If a position is removed, divide aFactor by m and multiply bFactor by m + 1.
		// TODO Add (aFactor * bFactor) to the running count.
		
		// Since <em>a</em> and <em>b</em> are really indistinguishable, to
		// count the number of distinct solutions, we have to divide by two.
		// Actually we have to add one before dividing by two because the
		// a = 1, b = 1 solution is only counted once.
		return (count + 1) / 2;
	}

}
