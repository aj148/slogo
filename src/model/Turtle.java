package model;

import java.util.Observable;

import view.ViewPanel;
import commands.TurtleCommand;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Turtle extends Observable {
    
    public Point2D myPoint;
    public double myHeading;
    public int isPenDown;
    public int isShowing;
    public Color myColor;
    
    public Turtle(int x, int y, ViewPanel view) {
        myPoint = new Point2D(x, y);
        myHeading = 0;
        isPenDown = 1;
        isShowing = 1;
        myColor = new Color(0.0, 0.0, 0.0, 1.0);
        addObserver(view);
    }
    
    public void updateTurtle(TurtleCommand command) {
    	command.executeCommand(Turtle.this);
    }
}