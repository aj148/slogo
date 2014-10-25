package model;

import java.util.Set;
import java.util.Stack;

public class TurtleListManager {
    private Stack<Set<Turtle>> myStack;
    private Set<Turtle> mySet;

    public TurtleListManager (Set<Turtle> myTurtles) {
        mySet = myTurtles;
        myStack = new Stack<Set<Turtle>>();
    }

    public void add (Set<Turtle> newSet) {
        myStack.add(newSet);
    }

    public void regulateDepth (int finalLength) {
        while (getStackLength() != finalLength) {
            myStack.pop();
        }
    }

    public void addTurtle (int ID) {
        mySet.add(new Turtle(ID));
    }

    public Set<Turtle> getCurrentSet () {
        return myStack.lastElement();
    }

    public Set<Turtle> getFullSet () {
        return mySet;
    }

    public int getStackLength () {
        return myStack.size();
    }
}