package model;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TurtleSetManager {
	
    private Stack<Set<Turtle>> myStack;
    private Set<Turtle> mySet;

    public TurtleSetManager (Set<Turtle> turtles) {
        mySet = turtles;
        mySet.add(new Turtle(0));
        myStack = new Stack<Set<Turtle>>();
        myStack.add(mySet);
    }

    public void addTurtleSet (Set<Turtle> newSet) {
        myStack.add(newSet);
    }

    public void regulateTurtleDepth (int finalLength) {
        while (getStackLength() != finalLength) {
            myStack.pop();
        }
    }

    public void addTurtle (int ID) {
        mySet.add(new Turtle(ID));
    }

    public Set<Turtle> getActiveTurtles () {
        return myStack.lastElement();
    }

    public Set<Turtle> getFullSet () {
        return mySet;
    }

    public int getStackLength () {
        return myStack.size();
    }
}