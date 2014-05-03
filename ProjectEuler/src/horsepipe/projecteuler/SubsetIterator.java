package horsepipe.projecteuler;

import java.util.Iterator;

public class SubsetIterator implements Iterator<int[]>{
	private int n;
	private int k;
	private boolean started;
	private boolean done;
	private int[] subset;
	
	public SubsetIterator(int n, int k) {
		this.n = n;
		this.k = k;
		this.started = false;
		if (n <= 0 || k < 0 || k > n) {
			this.done = true;
		} else {
			this.done = false;
		}
		this.subset = new int[k];
		for (int i = 0; i < k; i++) {
			this.subset[i] = i;
		}
	}

	@Override
	public boolean hasNext() {
		return (!done);
	}

	@Override
	public int[] next() {
		if (!started) {
			started = true;
			if (k == n) {
				done = true;
			}
			return subset.clone();
		} else {
			int index = k - 1;
			while (index >= 0) {
				if (subset[index] + (k - index) < n) {
					subset[index]++;
					if (index == 0 && subset[index] == n - k) {
						done = true;
					}
					for (int i = index + 1; i < k; i++) {
						subset[i] = subset[i - 1] + 1;
					}
					return subset.clone();
				}
				index--;
			}
		}
		return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
