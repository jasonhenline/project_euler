package horsepipe.projecteuler;

import java.math.BigInteger;

public class Utils {
	
	public static BigInteger binomialCoefficient(BigInteger n, BigInteger k) {
		if (n.compareTo(BigInteger.ZERO) < 0
				|| k.compareTo(BigInteger.ZERO) < 0) {
			throw new RuntimeException("negative argument");
		}
		if (n.compareTo(k) < 0) {
			throw new RuntimeException(
					"second argument is greater than first argument");
		}
		
		k = k.min(n.subtract(k));
		if (k.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		
		BigInteger numerator = n.subtract(k).add(BigInteger.ONE);
		BigInteger denominator = BigInteger.ONE;
		BigInteger value = numerator;
		while (numerator.compareTo(n) < 0) {
			numerator = numerator.add(BigInteger.ONE);
			denominator = denominator.add(BigInteger.ONE);
			value = value.multiply(numerator).divide(denominator);
		}
		return value;
	}

}
