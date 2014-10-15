package commands;

public class OrCommand extends TwoInputCommand {

	@Override
	public double executeCommand() {
		return (myParameterOne.executeCommand() != 0 || myParameterTwo.executeCommand() != 0) ? 0 : 1;
	}
}