package commands;

import model.Model;
import model.Turtle;


/**
 * Command class which all the other sub command classes extend
 * 
 * @author team14
 *
 */
public abstract class Command {

    protected Command[] myParameters;

    /**
     * Constructor for Command object with no input
     */
    public Command () {
        myParameters = new Command[0];
    }

    /**
     * Constructor for Command object with one or more than one input
     * @param numParameters - number of parameters
     */
    public Command (int numParameters) {
        myParameters = new Command[numParameters];
    }

    public int getNumParameters () {
        return myParameters.length;
    }

    public void setParameters (Command[] parameters) {
        for (int i = 0; i < myParameters.length; i++) {
            myParameters[i] = parameters[i];
        }
    }

    public Command getParameter (int index) {
        return myParameters[index];
    }

    /**
     * This method executes a specific command on each turtle in the given model
     * 
     * @param model - contains all the active turtles 
     * @return the last turtle on which command was executed
     */
    public double executeCommand (Model model) {
        double last = 0;
        for (Turtle a : model.getTurtleManager().getActiveTurtles()) {
            last = updateTurtle(model, a);
        }
        model.notifyView();
        return last;
    }

    protected double updateTurtle (Model model, Turtle a) {
        return 0;
    }

    protected Turtle getFirstTurtle (Model model) {
        return model.getTurtleManager().getActiveTurtles().iterator().next();
    }

    public String getClassName () {
        return this.getClass().getName();
    }
}
