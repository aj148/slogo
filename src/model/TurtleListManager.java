package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import view.ViewPane;

public class TurtleListManager {
	private Stack<Set<Turtle>> myStack;
	private Set<Turtle> mySet;

	public TurtleListManager(Set<Turtle> myTurtles) {
		mySet = myTurtles;
		new Stack<Set<Turtle>>();
	}

	public void add(Set<Integer> newList) {
		Set<Turtle> a = new HashSet<Turtle>();
		newList.forEach(e -> a.add(new ArrayList<Turtle>(mySet).get(e)));
		myStack.add(a);
	}

	public void regulateDepth() {
		myStack.pop();
	}

	public void addTurtle(int ID, ViewPane view) {
		mySet.add(new Turtle(0, 0, view, ID));
	}

	public Set<Turtle> getCurrentList() {
		return myStack.lastElement();
	}
}