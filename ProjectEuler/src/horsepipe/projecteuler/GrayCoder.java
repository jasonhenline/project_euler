package horsepipe.projecteuler;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GrayCoder implements Iterator<GrayCodeStep> {
	private final int numberOfBits;
	private final int numberOfSteps;
	private int stepNumber;
	private int pattern;
	
	public GrayCoder(int numberOfBits) {
		this.numberOfBits = numberOfBits;
		this.numberOfSteps = 1 << numberOfBits;
		this.stepNumber = 0;
		this.pattern = 0;
	}
	
	public int getPattern() {
		return pattern;
	}

	@Override
	public boolean hasNext() {
		return stepNumber < numberOfSteps - 1;
	}

	@Override
	public GrayCodeStep next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		stepNumber++;
		int newPattern = (stepNumber >> 1) ^ stepNumber;
		int diff = pattern ^ newPattern;
		int position = 0;
		for (int p = 0; p < numberOfBits; p++) {
			int mask = 1 << p;
			if ((mask & diff) != 0) {
				position = p;
				break;
			}
		}
		boolean isTurnOn = ((diff & pattern) == 0);
		pattern = newPattern;
		return new GrayCodeStep(isTurnOn, position);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
