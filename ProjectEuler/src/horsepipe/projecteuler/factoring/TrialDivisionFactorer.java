package horsepipe.projecteuler.factoring;

import java.util.TreeMap;

public class TrialDivisionFactorer implements Factorer {

	@Override
	public TreeMap<Long, Long> factor(long n) {
		TreeMap<Long, Long> factors = new TreeMap<Long, Long>();
		if (n < 0) {
			n = -n;
		}
		long sqrt = (long) Math.floor(Math.sqrt(n));
		for (long d = 2; d <= sqrt; d++) {
			long multiplicity = 0;
			while (n % d == 0) {
				multiplicity++;
				n /= d;
			}
			if (multiplicity > 0) {
				factors.put(d, multiplicity);
			}
		}
		if (n != 1L) {
			factors.put(n, 1L);
		}
		return factors;
	}

}
