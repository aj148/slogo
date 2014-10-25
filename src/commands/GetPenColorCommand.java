package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;
import model.Turtle;

public class GetPenColorCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		List<Turtle> temp=new ArrayList<Turtle>(model.getManager().getCurrentList());
		return temp.get(temp.size()-1).getPenColor();
	}
}