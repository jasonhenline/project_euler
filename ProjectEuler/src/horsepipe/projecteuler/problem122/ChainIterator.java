package horsepipe.projecteuler.problem122;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChainIterator implements Iterator<Integer> {
	
	private static class Node {
		private boolean base;
		private Node[] container;
		private int index;
		
		int firstParentIndex;
		int secondParentIndex;
		int value;
		
		static Node getBase(int value, Node[] container) {
			Node node = new Node();
			node.base = true;
			node.firstParentIndex = -1;
			node.secondParentIndex = -1;
			node.value = value;
			node.container = container;
			node.index = 0;
			return node;
		}
		
		Node(int firstParentIndex, int secondParentIndex, Node[] container, int index) {
			this.firstParentIndex = firstParentIndex;
			this.secondParentIndex = secondParentIndex;
			this.container = container;
			rectify();
			this.base = false;
			this.index = index;
		}
		
		private Node() {}
		
		private void rectify() {
			value = container[firstParentIndex].value
					+ container[secondParentIndex].value;
		}
		
		boolean increment() {
			if (base) {
				return false;
			} else if (secondParentIndex < firstParentIndex) {
				secondParentIndex++;
				rectify();
				return true;
			} else if (firstParentIndex + 1 < index) {
				firstParentIndex++;
				secondParentIndex = 0;
				rectify();
				return true;
			} else {
				return false;
			}
		}
		
		boolean incrementUntilIncreasing() {
			while(increment()) {
				if (value > container[index - 1].value) {
					return true;
				}
			}
			return false;
		}
		
		void zero() {
			firstParentIndex = 0;
			secondParentIndex = 0;
			rectify();
		}
		
		@Override
		public String toString() {
			return Integer.toString(value)
					+ " = [" + firstParentIndex + "] + [" 
					+ secondParentIndex + "]";
		}
	}
	
	private Node[] chain;
	private boolean done;
	
	ChainIterator(int chainLength) {
		chain = new Node[chainLength];
		chain[0] = Node.getBase(1, chain);
		for (int i = 1; i < chainLength; i++) {
			chain[i] = new Node(0, 0, chain, i);
			chain[i].incrementUntilIncreasing();
		}
		done = false;
	}

	@Override
	public boolean hasNext() {
		return (!done);
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		int value = chain[chain.length - 1].value;
		int index = chain.length - 1;
		while (index > 0) {
			if (chain[index].incrementUntilIncreasing()) {
				for (int i = index + 1; i < chain.length; i++) {
					chain[i].zero();
					chain[i].incrementUntilIncreasing();
				}
				return value;
			}
			index--;
		}
		done = true;
		return value;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}
