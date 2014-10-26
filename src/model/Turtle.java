package model;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class Turtle implements Comparable<Object> {
	
    private static final double PI = Math.PI;
    private double myID;
     
    private double myHeading;
    private double isShowing;
    private Pen myPen;
    private List<Point2D> myTurtlePoints = new ArrayList<Point2D>();
    private Point2D myFirstPoint;
    private Point2D myCurrPoint; 
    private Point2D myNextPoint;  

    public Turtle (double ID) {
    	myID = ID;
        myFirstPoint = new Point2D(0, 0);
        myTurtlePoints.add(myFirstPoint);
        myCurrPoint = myTurtlePoints.get(myTurtlePoints.size()-1);
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
        myCurrPoint = myCurrPoint.add(x, y);
        myNextPoint = myCurrPoint;
        myTurtlePoints.add(myNextPoint);
        getmyCurr();
        return Math.abs(forward);
    }

    public void getmyCurr(){
    	myCurrPoint = myTurtlePoints.get(myTurtlePoints.size()-1);
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
    	getmyCurr();
        double deltaX = x - myCurrPoint.getX();
        double deltaY = y - myCurrPoint.getY();
        double oldHeading = toRadians(myHeading);
        double newHeading = Math.atan(deltaX / deltaY);
        myHeading = newHeading;
        return oldHeading - toRadians(newHeading);
    }

    public double setXAndY (double x, double y) {
    	getmyCurr();
    	double curX = myCurrPoint.getX();
        double curY = myCurrPoint.getY();
        // did this so i could have it done before i reset myPoint just to be safe
        double root = Math.sqrt((x - curX) * (x - curX) + (y - curY) * (y - curY));
        myCurrPoint = new Point2D(x, y);
        myTurtlePoints.add(myCurrPoint);
        getmyCurr();
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

    public Point2D getNewLocation () {
        return myTurtlePoints.get(myTurtlePoints.size() - 1);
    }
    
    public Point2D getPrevLocation () {
    	if(myTurtlePoints.size() > 2)
    		return myTurtlePoints.get(myTurtlePoints.size() - 2);
    	return myFirstPoint;
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
