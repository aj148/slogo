package model;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import view.Draw;
import view.panes.ViewPane;

import commands.TurtleCommand;

public class Turtle {

    private static final double PI = 3.1415927;
    private ViewPane myView;
    private Point2D myPoint;
    private double myHeading;
    private double isPenDown;
    private double isShowing;
    private Color myColor;
    private Draw myDraw = new Draw();

    public Turtle (int x, int y, ViewPane view) {
        myPoint = new Point2D(x, y);
        myHeading = 0;
        isPenDown = 1;
        isShowing = 1;
        myColor = new Color(0.0, 0.0, 0.0, 1.0);
        myView = view;
    }

    public void updateTurtle (TurtleCommand command) {
        command.executeCommand(Turtle.this);
        // observeHelper();
        myView.updateView(this);
    }

    public double updatePosition (double forward) {
        double radians = toRadians(myHeading);
        double x = forward * Math.sin(radians);
        double y = forward * Math.cos(radians) * -1;
        myPoint = myPoint.add(x, y);
        return Math.abs(forward);
    }

    private double toRadians (double degrees) {
        return degrees * PI / 180.0;
    }

    public double updateHeading (double degree) {
        myHeading += degree;
        myHeading = myHeading % 360;
        return degree;
    }

    public double getHeading () {
        return myHeading;
    }

    public double setHeading (double degree) {
        double toReturn = degree - myHeading;
        myHeading = degree;
        return toReturn;
    }

    public double towards (Point2D point) {
        double x = point.getX() - myPoint.getX();
        double y = point.getY() - myPoint.getY();
        double oldHeading = myHeading;
        double newHeading = Math.atan(x / y);
        myHeading = newHeading;
        return oldHeading - newHeading;
    }

    public double setXAndY (double x, double y) {
        double curX = myPoint.getX();
        double curY = myPoint.getY();
        // did this so i could have it done before i reset myPoint just to be
        // safe
        double root = Math.sqrt((x - curX) * (x - curX) + (y - curY) * (y - curY));
        myPoint = new Point2D(x, y);
        return root;
    }

    public double changePen (double pen) {
        if (pen == 1.0 || pen == 0.0) {
            isPenDown = pen;
        }
        return isPenDown;
    }

    public double changeVisibility (double visible) {
        if (visible == 1.0 || visible == 0.0) {
            isShowing = visible;
        }
        return isShowing;
    }

    public double getXOrY (int xOrY) {
        if (xOrY == 0) {
            return myPoint.getX();
        } else if (xOrY == -1) {
            return myPoint.getY();
        }
        return -1;
    }

    public Point2D getLocation () {
        return myPoint;
    }

    public double getPenStatus () {
        return isPenDown;
    }

    public double getShowing () {
        return isShowing;
    }

    public Color getPenColor () {
        return myColor;
    }
}
