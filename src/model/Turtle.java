package model;

import javafx.geometry.Point2D;

public class Turtle implements Comparable<Object> {
	
    private static final double PI = Math.PI;
    private double myID;
    private Point2D myPoint;
    private double myHeading;
    private double isShowing;
    private Pen myPen;

    public Turtle (double ID) {
    	myID = ID;
        myPoint = new Point2D(0, 0);
        myHeading = 0;
        isShowing = 1;
        myPen = new Pen();
    }
    
    @Override
	public int compareTo(Object obj) {
    	if (obj == null || this.getClass() != obj.getClass()) {
            return 0;
        }
        Turtle turtle = (Turtle) obj;
		return (int)this.myID - (int)turtle.myID;
	}

    public double updatePosition (double forward) {
        double radians = toRadians(myHeading);
        double x = forward * Math.sin(radians);
        double y = forward * -Math.cos(radians);
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
    
    public double setPenColor (double red, double green, double blue) {
        return myPen.updateColor(red, green, blue);
    }

    public double changeVisibility (double visible) {
        if (visible == 1.0 || visible == 0.0) {
            isShowing = visible;
        }
        return isShowing;
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

    public double getPenColor () {
        return myPen.getColor();
    }

    public double getID () {
        return myID;
    }
}