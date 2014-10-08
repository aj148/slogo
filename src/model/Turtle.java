package model;

import java.util.Observable;

import view.ViewPanel;
import commands.TurtleCommand;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Turtle extends Observable {

    public Point2D myPoint;
    private double myHeading;
    private int isPenUp;
    private int isInvisible;
    private Color myColor;

    public Turtle(int x, int y, ViewPanel view) {
        myPoint = new Point2D(x, y);
        myHeading = 0;
        isPenUp = 0;
        isInvisible = 0;
        myColor = new Color(0.0, 0.0, 0.0, 1.0);
        addObserver(view);
    }
    
    public void updateTurtle(TurtleCommand command) {
        try{
            command.executeCommand(Turtle.this);
        }
        catch(Exception e) {
            System.out.println("This is an error that will be fixed");
        }
    }
}
