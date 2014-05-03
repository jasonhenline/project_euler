package horsepipe.projecteuler.factoring;

import java.util.TreeMap;

public interface Factorer {

	/**
	 * @param n The number to be factored.
	 * @return A map from prime factors to multiplicity.
	 */
	public TreeMap<Long, Long> factor(long n);

}
