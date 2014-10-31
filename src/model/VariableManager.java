// This entire file is part of my masterpiece.
// Ben Reisner
package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;

public class VariableManager extends MasterpieceSuper {
	/**
	 * Class used to manage variables and scope
	 */
	private LinkedList<Set<MasterpieceObject>> myLinkedList;

	public VariableManager() {
		myLinkedList = new LinkedList<Set<MasterpieceObject>>();
	}

	/**
	 * Method to add a map to the LinkedList.
	 *
	 * @param newMap
	 *            : map to be added to the LinkedList.
	 */
	public void addVariableMap(Set<MasterpieceObject> newSet) {
		super.add(myLinkedList, newSet);
	}

	/**
	 * Method to reduce the length of the LinkedList by one to reduce scope
	 */
	public void reduceVariableScope() {
		super.reduceScope(1, myLinkedList);
	}

	/**
	 * Method to get the global variables.
	 */
	public Collection getGlobalVariables() {
		return new HashSet(super.getHighestLevel(myLinkedList));
	}

	/**
	 * Method to get the local variables only.
	 */
	public Collection getLocalVariables() {
		return new HashSet(super.getLowestLevel(myLinkedList));
	}

	/**
	 * Method to add a global variable.
	 *
	 * @param varName
	 *            , varValue : String and double corresponding to variable and
	 *            its value.
	 */
	public void addGlobalVariable(String varName, double varValue) {
		this.getGlobalVariables().add(new MasterpieceObject(varName, varValue));
	}

	/**
	 * same as above, but for local variables
	 */
	public void addLocalVariable(String varName, double varValue) {
		Set<MasterpieceObject> currentVariables = myLinkedList.pop();
		currentVariables.add(new MasterpieceObject(varName, varValue));
		myLinkedList.add(currentVariables);
	}

	public int getVariableScope() {
		return myLinkedList.size();
	}
}
