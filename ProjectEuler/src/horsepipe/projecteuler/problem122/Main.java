package horsepipe.projecteuler.problem122;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
	
	private static final int N = 200;

	public static void main(String[] args) {
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		m.put(1, 1);
		int length = 1;
		
		while (incomplete(m)) {
			length++;
			System.out.println("Length " + length);
			Iterator<Integer> iterator = new ChainIterator(length);
			while (iterator.hasNext()) {
				int value = iterator.next();
				if (!m.containsKey(value)) {
					m.put(value, length);
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += m.get(i) - 1;
		}
		System.out.println("Sum m() = " + sum);
	}
	
	private static boolean incomplete(Map<Integer, Integer> m) {
		for (int i = 1; i <= N; i++) {
			if (!m.containsKey(i)) {
				System.out.println("Missing " + i);
				return true;
			}
		}
		return false;
	}
}
