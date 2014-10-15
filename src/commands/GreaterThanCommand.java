package commands;

public class GreaterThanCommand extends TwoInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne.executeCommand() > myParameterTwo.executeCommand()) ? 1 : 0;
	}
}