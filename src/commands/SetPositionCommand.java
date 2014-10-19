package commands;

import model.Turtle;

public class SetPositionCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand (Turtle turtle) {
       return turtle.setXAndY(myParameterOne.executeCommand(turtle), myParameterTwo.executeCommand(turtle));
    }
}