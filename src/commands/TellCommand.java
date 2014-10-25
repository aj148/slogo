package commands;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;

import model.Model;
import model.Turtle;
import model.TurtleListManager;

public class TellCommand extends OneInputCommand {
	
	@Override
	public double executeCommand(Model model){
		TurtleListManager temp = model.getManager();
		double toReturn = 0;
		Set<Turtle> tellSet = new TreeSet<Turtle>();
		List<Turtle> fullList = new ArrayList<Turtle>(temp.getFullList());
		List<Command> turtlesToAdd = ((ListCommand) myParameterOne).getList();
		boolean exists = false;
		for(Command a: turtlesToAdd) {
			exists=false;
			toReturn = a.executeCommand(model);
			for(Turtle b: fullList) {
				if(toReturn == b.getID()) {
					tellSet.add(b);
					exists = true;
					break;
				}
			}
			if(!exists) {
				temp.getFullList().add(new Turtle(0, 0, model.getView(), toReturn));
			}
		}
		temp.add(tellSet);
		return toReturn;
	}
}