package commands;

public class LessThanCommand extends TwoInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne < myParameterTwo) ? 1 : 0;
	}
}