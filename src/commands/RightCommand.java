package commands;

import model.Model;
import model.Turtle;

<<<<<<< HEAD
public class RightCommand extends OneInputCommand implements TurtleCommand {

    @Override
    public double executeCommand (Turtle turtle) {
        return turtle.updateHeading(myParameterOne);
    }
=======
public class RightCommand extends OneInputCommand {

//	@Override
//	public double executeCommand(Model model) {
//		double toReturn = 0;
//		for (Turtle a : model.getManager().getCurrentList()) {
//			toReturn = a.updateHeading(myParameterOne.executeCommand(model));
//		}
//		return toReturn;
//	}
	
	   public double updateTurtle(Model model, Turtle a) {
	        return a.updateHeading(myParameterOne.executeCommand(model));
	    }
>>>>>>> origin/backend
}