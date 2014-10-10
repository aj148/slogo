package view;

import java.util.Observable;
import java.util.Observer;


/**
 * Contains an Observable String that represents the current command being passed into the Front
 * End. Allows Observers to detect that a new command has been input and make the appropriate method
 * calls in response to the command input.
 * 
 * @author Team 14
 *
 */
public class CommandString extends Observable {

    /**
     * String containing the current command
     */
    private String myCommand;

    /**
     * Constructor that adds an observer
     * 
     * @param o Observer to be added to CommandString
     */
    public CommandString (Observer o) {
        addObserver(o);
        myCommand = "";
    }

    /**
     * Setter to set the current command
     * 
     * @param s String representing the current command
     */
    public void setCommand (String s) {
        myCommand = s;
        setChanged();
        notifyObservers();
    }

    /**
     * Getter to get the current command
     * 
     * @return String containing the current command
     */
    public String getCommand () {
        return myCommand;
    }

}
