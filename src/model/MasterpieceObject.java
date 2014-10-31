// This entire file is part of my masterpiece.
// Ben Reisner
package model;

public class MasterpieceObject {
	String myString;
	double myDouble;

	public MasterpieceObject(String a, double b) {
		myString = a;
		myDouble = b;
	}

	public double getDouble() {
		return myDouble;
	}

	public String getString() {
		return myString;
	}
}
