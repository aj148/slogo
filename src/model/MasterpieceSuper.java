// This entire file is part of my masterpiece.
// Ben Reisner
package model;

import java.util.Collection;
import java.util.LinkedList;

public class MasterpieceSuper {

	public void add(Collection a, Object b) {
		a.add(b);
	}

	public void reduceScope(int a, LinkedList b) {
		while (b.size() != a) {
			b.removeLast();
		}
	}

	public Collection getHighestLevel(LinkedList a) {
		return (Collection) a.getFirst();
	}

	public Collection getLowestLevel(LinkedList a) {
		return (Collection) a.getLast();
	}

}
