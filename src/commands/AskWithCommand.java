package commands;

import model.Model;
import model.Turtle;

public class AskWithCommand extends TwoInputCommand {
    
    @Override
    public double executeCommand(Model model) {
        //go through turtles, create ask with ids, execute
    	for(Turtle cur: model.getTurtleManager().getActiveTurtles())
    	{
    		IfCommand temp=new IfCommand();
    		temp.
    	}
    }
}