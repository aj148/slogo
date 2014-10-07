package model;

import java.util.Collection;
import java.util.Observable;

import view.ViewPanel;
import commands.Command;
import javafx.geometry.Point2D;

public class Turtle extends Observable {

	private Point2D myPoints;
	private double myHeading;
	private int isPenUp;
	private int isInvisible;

	public Turtle(int x, int y, ViewPanel view) {
		myPoints = new Point2D(x, y);
		myHeading = 0;
		isPenUp = 0;
		isInvisible = 0;
		addObserver(view);
	}

	public void updateTurtle(Collection<Command> commands) {
		for(Command command: commands)
		{
			try{
			command.executeCommand(this);
			}
			catch(Exception e)
			{
				System.out.println("This is an error that will be fixed");
			}
		}
	}
}
