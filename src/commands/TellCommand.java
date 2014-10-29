package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import model.Model;
import model.Turtle;
import model.TurtleSetManager;

public class TellCommand extends OneInputCommand {
	/**
	 * sets active turtles, creates a new one if a specified turtle isn't in the
	 * list, returns the value of the last turtle's id
	 *
	 */
	@Override
	public double executeCommand(Model model) {
		TurtleSetManager temp = model.getTurtleManager();
		double toReturn = 0;
		Set<Turtle> tellSet = new TreeSet<Turtle>();
		List<Turtle> fullList = new ArrayList<Turtle>(temp.getAllTurtles());
		List<Command> turtlesToAdd = ((ListCommand) myParameters[0]).getList();
		boolean exists = false;
		for (Command a : turtlesToAdd) {
			exists = false;
			toReturn = a.executeCommand(model);
			for (Turtle b : fullList) {
				if (toReturn == b.getID()) {
					tellSet.add(b);
					exists = true;
					break;
				}
			}
			if (!exists) {
				Turtle cur = new Turtle(toReturn);
				temp.getAllTurtles().add(cur);
				tellSet.add(cur);
			}
		}
		temp.addTurtleCollection(tellSet);
		return toReturn;
	}
}
