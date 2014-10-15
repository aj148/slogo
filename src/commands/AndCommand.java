package commands;

public class AndCommand extends TwoInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne.executeCommand() == 0 && myParameterTwo.executeCommand() == 0) ? 1 : 0;
	}
}