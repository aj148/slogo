package commands;

public class DoTimesCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand() {
    	ListCommand A=new ListCommand();
    	A.setParameters((VariableCommand) myParameterOne);
    	A.setParameters(new NumberCommand(0));
    	A.setParameters(new NumberCommand(5));
    	A.setParameters(new NumberCommand(1));
    	ForCommand B=new ForCommand();
    	B.setParameters(A, (ListCommand) myParameterTwo);
    	double toReturn=B.executeCommand();
    	return toReturn;
    }
}