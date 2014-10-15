package commands;

import model.Turtle;

public class SetPositionCommand extends TwoInputCommand implements TurtleCommand {
	
	@Override
    public double executeCommand (Turtle turtle) {
       return turtle.setXAndY(myParameterOne.executeCommand(), myParameterTwo.executeCommand());
    }
}