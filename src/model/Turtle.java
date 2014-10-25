package model;

import view.panes.ViewPaneModule;
import commands.Command;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Turtle {
    private static final double PI = Math.PI;
    private ViewPaneModule myView;
    private Point2D myPoint;
    private double myHeading;
    private double isShowing;
    private Pen myPen;
    /*
     * private Color myColor; private double mySize;
     */
    private double myID;

    public Turtle (int x, int y, ViewPaneModule view, double ID) {
        myPoint = new Point2D(x, y);
        myHeading = 0;
        isShowing = 1;
        myView = view;
        myID = ID;
        myPen = new Pen();
    }

    @Override
    public boolean equals (Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Turtle obj = (Turtle) o;
        return this.myID == obj.myID;
    }

    public double updatePosition (double forward) {
        double radians = toRadians(myHeading);
        double x = forward * Math.sin(radians);
        double y = forward * Math.cos(radians) * -1;
        myPoint = myPoint.add(x, y);
        return Math.abs(forward);
    }

    public double setPenSize (double size) {
        myPen.updateSize(size);
        return size;
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

    public double towards (double x, double y) {
        // This is faulty. Very faulty.
        double deltaX = x - myPoint.getX();
        double deltaY = y - myPoint.getY();
        double oldHeading = toRadians(myHeading);
        double newHeading = Math.atan(deltaX / deltaY);
        myHeading = newHeading;
        return oldHeading - toRadians(newHeading);
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
            myPen.setPenStatus(pen);
        }
        return myPen.getStatus();
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
        return myPen.getStatus();
    }

    public double getShowing () {
        return isShowing;
    }

    public Color getPenColor () {
        return myPen.getColor();
    }

    public double getID () {
        return myID;
    }
}
