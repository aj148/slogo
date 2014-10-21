package commands;
import model.Model;


public class ForwardCommand extends OneInputCommand {
	
    @Override
    public double executeCommand (Model model) {
    	System.out.println("Executing ForwardCommand.");
        return turtle.updatePosition(myParameterOne.executeCommand(null));
    }

    public char[] getParameter () {
        // TODO Auto-generated method stub
        return null;
    }
}