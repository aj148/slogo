package model;

import java.util.Set;
import java.util.Stack;

/**
 * Class the contains various lists of turtles, used to manage scope of the
 * turtle
 */
public class TurtleSetManager {

	private Stack<Set<Turtle>> myStack;
	private Set<Turtle> mySet;

	public TurtleSetManager(Set<Turtle> turtles) {
		mySet = turtles;
		// mySet.add(new Turtle(0));
		myStack = new Stack<Set<Turtle>>();
		myStack.add(mySet);
	}

	/**
	 * Method to add a set to the current stack of sets of turtles.
	 *
	 * @param newSet
	 *            : the set to be added.
	 */
	public void addTurtleCollection(Set<Turtle> newSet) {
		myStack.add(newSet);
	}

	/**
	 * Method to regulate the depth of the stack.
	 *
	 * @param finalLength
	 *            : integer representing the length the stack should be when
	 *            this is called.
	 */
	public void regulateTurtleDepth(int finalLength) {
		while (getStackLength() != finalLength) {
			myStack.pop();
		}
	}

	/**
	 * Method to add a turtle to the whole collection of turtles, don't think
	 * it's used.
	 *
	 * @param id
	 *            : adds new turtle with ID int id.
	 */
	public void addTurtle(int id) {
		mySet.add(new Turtle(id));
	}

	/**
	 * Method to return collection of currently active turtles.
	 */
	public Set<Turtle> getActiveTurtles() {
		return myStack.lastElement();
	}

	/**
	 * Method to return collection of all turtles
	 */
	public Set<Turtle> getAllTurtles() {
		return mySet;
	}

	/**
	 * Method to get the length of the stack, used in regulatedepth for ease in
	 * typing.
	 */
	public int getStackLength() {
		return myStack.size();
	}
}
