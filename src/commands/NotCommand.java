package commands;

public class NotCommand extends OneInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne != 0) ? 0 : 1;
	}
}