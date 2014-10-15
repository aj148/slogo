package commands;

public class LessThanCommand extends TwoInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne.executeCommand() < myParameterTwo.executeCommand()) ? 1 : 0;
	}
}