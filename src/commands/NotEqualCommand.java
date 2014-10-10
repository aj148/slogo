package commands;

public class NotEqualCommand extends TwoInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne == myParameterTwo) ? 0 : 1;
	}
}