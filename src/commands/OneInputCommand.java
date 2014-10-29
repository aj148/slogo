package commands;

public abstract class OneInputCommand extends Command {
	/**
	 * super for all of the commands that require only one parameter
	 * 
	 * @author team14
	 *
	 */
    public OneInputCommand () {
        super(1);
    }
}
