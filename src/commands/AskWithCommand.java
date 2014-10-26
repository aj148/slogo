package commands;

import java.util.Set;

import model.Model;
import model.Turtle;

public class AskWithCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Model model) {
    	int currentStackLength = model.getTurtleManager().getStackLength();
    	Set<Turtle> allTurtles = model.getTurtleManager().getAllTurtles();
    	ListCommand turtleList = new ListCommand();
    	TellCommand a = new TellCommand();
    	for(Turtle turtle : allTurtles){
    		ConstantCommand[] turtleID = {new ConstantCommand(turtle.getID())};
    		a.setParameters(turtleID);
    		if(myParameters[0].executeCommand(model) != 0){
    			turtleList.addParameter(new ConstantCommand(turtle.getID()));
    			System.out.println(turtle.getID());
    		}
    	}
    	ListCommand[] metConditions = {turtleList};
    	a.setParameters(metConditions);
    	a.executeCommand(model);
		double toReturn = myParameters[1].executeCommand(model);
		model.getTurtleManager().regulateTurtleDepth(currentStackLength);
		return toReturn;
    }
}