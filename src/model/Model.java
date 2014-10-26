package model;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import javafx.scene.paint.Color;
import commands.Command;
import view.panes.ViewPaneModule;

/**
 * Class that contains the basic information of what needs to be displayed in
 * the GUI, including data related to the turtle (current position, pen color,
 * pen up/down). The Model is always updated before the ViewPanel is updated.
 *
 * @author Team 14
 */
public class Model {
	
    private ViewPaneModule myView;
    private Color myBackground;
    private Set<Turtle> myFullSet;
    private TurtleSetManager myTurtleManager;
    private VariableManager myVariableManager;
    private double isStamp;

    /**
     * Constructor method called from ViewPanel.java
     *
     * @param view : The ViewPanel that called this constructor.
     */
    public Model (ViewPaneModule view) {
        myFullSet = new TreeSet<Turtle>();
        myView = view;
        myTurtleManager = new TurtleSetManager(myFullSet);
        myVariableManager = new VariableManager();
        myBackground = Color.WHITE;
        isStamp=0.0;
    }

    /**
     * Method to update the model with the commands passed from the Controller.
     *
     * @param commandsToExecute
     *            : Collection of commands to execute.
     */
    public void updateModel (Collection<Command> commandsToExecute) {
        for (Command command : commandsToExecute) {
        	command.executeCommand(this);
        	notifyView();
        }
    }
    
    public void notifyView(){
    	myView.updateView(this);
    }

    public ViewPaneModule getView() {
        return myView;
    }

    public TurtleSetManager getTurtleManager() {
        return myTurtleManager;
    }
    
    public VariableManager getVariableManager(){
    	return myVariableManager;
    }

    public double setBackgroundColor (double red, double green, double blue) {
    	int r = (int)(255*red);
    	int g = (int)(255*green);
    	int b = (int)(255*blue);
    	myBackground = Color.rgb(r,g,b);
    	return red + (1000 * green) + (1000000 * blue);
    }

    public Color getBackgroundColor () {
        return myBackground;
    }
    
    public double getStamp()
    {
    	return isStamp;
    }
    
    public double setStamp(double stamp)
    {
    	isStamp=stamp;
    	return stamp;
    }
    
  
}