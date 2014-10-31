package commands;

public abstract class TwoInputCommand extends Command {
	/**
	 * super class for any command with three parameters/inputs
	 *
	 */
    public TwoInputCommand () {
        super(2);
    }
}
