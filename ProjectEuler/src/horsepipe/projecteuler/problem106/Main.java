package horsepipe.projecteuler.problem106;

import horsepipe.projecteuler.SubsetIterator;
import horsepipe.projecteuler.Utils;

import java.math.BigInteger;
import java.util.Iterator;

public class Main {
	
	public static int N = 12;

	public static void main(String[] args) {
		int sum = 0;
		for (int h = 2; 2*h <= N; h++) {
			int count = 0;
			Iterator<int[]> iterator = new SubsetIterator(2*h, h);
			while (iterator.hasNext()) {
				int[] next = iterator.next();
				if (next[0] != 0) {
					continue;
				}
				boolean[] inSet = new boolean[2*h];
				for (int index : next) {
					inSet[index] = true;
				}
				if (couldBeEqual(inSet)) {
					count++;
				}
			}
			BigInteger binomial =
					Utils.binomialCoefficient(
							BigInteger.valueOf(N),
							BigInteger.valueOf(2*h));
			sum += count * binomial.intValue(); 
		}
		System.out.println(sum);
	}
	
	/**
	 * Determines if two subsets could be equal
	 * 
	 * <p>The subsets are drawn from an ascending list of numbers of length
	 * {@code inSet.length}. The {@code inSet} array tells whether each element
	 * in the list is present in subset 1. If an element is not in subset 1, it
	 * is in subset 2.
	 * 
	 * It is known that subsets of larger cardinality have larger sums, so the
	 * two subsets can only be equal if they have the same number of elements.
	 * 
	 * This function assumes the cardinalities of the two sets are equal. The
	 * result is undefined if they are not equal.
	 * 
	 * This means the function assumes that the length of {@code inSet} is
	 * even. It also assumes that {@code inSet} is not empty.
	 */
	public static boolean couldBeEqual(boolean[] inSet) {
		int n = inSet.length / 2;
		boolean first = inSet[0];
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			boolean found = false;
			b = Math.max(a, b);
			for (int j = b + 1; j < inSet.length; j++) {
				if (inSet[j] != first) {
					b = j;
					found = true;
					break;
				}
			}
			if (!found) {
				return true;
			}
			for (int j = a + 1; j < inSet.length; j++) {
				if (inSet[j] == first) {
					a = j;
					break;
				}
			}
		}
		return false;
	}

}
