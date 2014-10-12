package commands;

public class NumberCommand extends Command {
	
	private double myParameter;
	
	public void setParameters(double parameter){
		myParameter = parameter;
	}
	
	@Override
	public double executeCommand(){
		return myParameter;
	}

	@Override
	public int getNumParameters() {
		return 1;
	}
}