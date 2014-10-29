package commands;

import model.Model;
import model.Turtle;


public class SetPositionCommand extends TwoInputCommand {
	/**
	 * sets position of active turtles, returns the value of setting x and y in turtle
	 * 
	 * @author team14
	 *
	 */
    @Override
    public double updateTurtle (Model model, Turtle a) {
        return a.setXAndY(myParameters[0].executeCommand(model),
                          myParameters[1].executeCommand(model));
    }
}
