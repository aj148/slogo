package model;

import java.util.Set;
import java.util.Stack;
import view.panes.ViewPaneModule;

public class TurtleListManager {
    private Stack<Set<Turtle>> myStack;
    private Set<Turtle> mySet;

    public TurtleListManager (Set<Turtle> myTurtles) {
        mySet = myTurtles;
        new Stack<Set<Turtle>>();
    }

    public void add (Set<Turtle> newSet) {
        myStack.add(newSet);
    }

    public void regulateDepth (int finalLength) {
        while (getStackLength() != finalLength) {
            myStack.pop();
        }
    }

    public void addTurtle (int ID, ViewPaneModule view) {
        mySet.add(new Turtle(0, 0, view, ID));
    }

    public Set<Turtle> getCurrentList () {
        return myStack.lastElement();
    }

    public Set<Turtle> getFullList () {
        return mySet;
    }

    public int getStackLength () {
        return myStack.size();
    }
}