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
    	for(Turtle turtle : allTurtles){
    		ConstantCommand[] turtleID = {new ConstantCommand(turtle.getID())};
    		if(myParameters[0].executeCommand(model) != 0){
    			turtleList.addParameter(new ConstantCommand(turtle.getID()));
    			System.out.println(turtle.getID());
    		}
    	}
    	ListCommand[] metConditions = {turtleList};
    	AskWithCommand stuff=new AskWithCommand();
    	Command[] st= { turtleList, myParameters[1] };
    	double toReturn = stuff.executeCommand(model);
		model.getTurtleManager().regulateTurtleDepth(currentStackLength);
		return toReturn;
    }
}