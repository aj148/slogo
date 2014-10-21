package commands;
import model.Model;


public class DoTimesCommand extends TwoInputCommand {
	
	@Override
    public double executeCommand(Model model) {
    	ListCommand A=new ListCommand();
    	A.setParameters((VariableCommand) myParameterOne);
    	A.setParameters(new ConstantCommand(0));
    	A.setParameters(new ConstantCommand(5));
    	A.setParameters(new ConstantCommand(1));
    	ForCommand B = new ForCommand();
    	B.setParameters(A, (ListCommand) myParameterTwo);
    	double toReturn = B.executeCommand(null);
    	return toReturn;
    }
}