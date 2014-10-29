package commands;

public abstract class ZeroInputCommand extends Command {
	/**
	 * super for commands that don't take any parameters
	 * 
	 * @author team14
	 *
	 */
	public ZeroInputCommand() {
		super(0);
	}
}
