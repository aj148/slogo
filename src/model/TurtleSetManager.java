// This entire file is part of my masterpiece.
// Ben Reisner
package model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.LinkedList;

/**
 * Class the contains various lists of turtles, used to manage scope of the
 * turtle
 */
public class TurtleSetManager extends MasterpieceSuper {

	private LinkedList<Set<Turtle>> myLinkedList;

	public TurtleSetManager(Set<Turtle> turtles) {
		// mySet.add(new Turtle(0));
		myLinkedList = new LinkedList<Set<Turtle>>();
		myLinkedList.add(turtles);
	}

	/**
	 * Method to add a set to the current LinkedList of sets of turtles.
	 *
	 * @param newSet
	 *            : the set to be added.
	 */
	public void addTurtleCollection(Set<Turtle> newSet) {
		super.add(myLinkedList, newSet);
	}

	/**
	 * Method to regulate the depth of the LinkedList.
	 *
	 * @param finalLength
	 *            : integer representing the length the LinkedList should be
	 *            when this is called.
	 */
	public void regulateTurtleDepth(int finalLength) {
		super.reduceScope(finalLength, myLinkedList);
	}

	/**
	 * Method to add a turtle to the whole collection of turtles, don't think
	 * it's used.
	 *
	 * @param id
	 *            : adds new turtle with ID int id.
	 */
	// didn't really modify because I don't think it's used, don't want to mess
	// with it
	public void addTurtle(int id) {
		getAllTurtles().add(new Turtle(id));
	}

	/**
	 * Method to return collection of currently active turtles.
	 */
	public Set<Turtle> getActiveTurtles() {
		return new HashSet(super.getLowestLevel(myLinkedList));
	}

	/**
	 * Method to return collection of all turtles
	 */
	public Set<Turtle> getAllTurtles() {
		return new HashSet(super.getLowestLevel(myLinkedList));
	}

	/**
	 * Method to get the length of the LinkedList, used in regulatedepth for
	 * ease in typing.
	 */
	public int getLinkedListLength() {
		return myLinkedList.size();
	}
}
