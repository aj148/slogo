package commands;

public class NotEqualCommand extends TwoInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne.executeCommand() == myParameterTwo.executeCommand()) ? 0 : 1;
	}
}