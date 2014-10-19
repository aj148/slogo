package commands;

import model.Turtle;

public class DoTimesCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Turtle turtle) {
    	ListCommand A=new ListCommand();
    	A.setParameters((VariableCommand) myParameterOne);
    	A.setParameters(new NumberCommand(0));
    	A.setParameters(new NumberCommand(5));
    	A.setParameters(new NumberCommand(1));
    	ForCommand B = new ForCommand();
    	B.setParameters(A, (ListCommand) myParameterTwo);
    	double toReturn = B.executeCommand(turtle);
    	return toReturn;
    }
}