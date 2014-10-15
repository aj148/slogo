package commands;

public class NotCommand extends OneInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne.executeCommand() != 0) ? 0 : 1;
	}
}