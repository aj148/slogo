package commands;

import java.util.Set;

import model.Model;
import model.Turtle;

public class AskWithCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Model model) {
    	int currentStackLength = model.getTurtleManager().getStackLength();
    	Set<Turtle> allTurtles = model.getTurtleManager().getFullSet();
    	ListCommand turtleList = new ListCommand();
    	for(Turtle turtle : allTurtles){
    		ConstantCommand[] turtleID = {new ConstantCommand(turtle.getID())};
    		if(myParameters[0].executeCommand(model) != 0){
    			turtleList.addParameter(new ConstantCommand(turtle.getID()));
    		}
    	}
    	AskCommand temp=new AskCommand();
    	Command[] myArray = {turtleList, myParameters[1]};
    	temp.setParameters(myArray);
		double toReturn = temp.executeCommand(model);
		model.getTurtleManager().regulateTurtleDepth(currentStackLength);
		return toReturn;
    }
}