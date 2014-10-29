package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Turtle implements Comparable<Object> {
	/**
	 * Class of Turtle, the object that is seen on the screen represented as a
	 * turtle.
	 */
	private static final int MYHEADING_CONVERSION_CONSTANT = 90;
	private static final double PI = Math.PI;
	private static final double RADIANS_TO_DEGREES = 180.0 / PI;
	private double myIdentification;
	private double myShapeIdentification;
	private double myHeading;
	private double isShowing;
	private Pen myPen;
	private List<Point2D> myTurtlePoints = new ArrayList<Point2D>();
	private Point2D myFirstPoint;
	private Point2D myCurrPoint;
	private Point2D myNextPoint;

	public Turtle(double identification) {
		myIdentification = identification;
		myFirstPoint = new Point2D(0, 0);
		myTurtlePoints.add(myFirstPoint);
		myCurrPoint = myTurtlePoints.get(myTurtlePoints.size() - 1);
		myHeading = 0;
		isShowing = 1;
		myPen = new Pen();
	}

	/**
	 * override of compareTo, don't think it's used
	 *
	 * @param obj
	 *            : what is being compared to.
	 */
	@Override
	public int compareTo(Object obj) {

		if (obj == null || this.getClass() != obj.getClass()) {
			return 0;
		}
		Turtle turtle = (Turtle) obj;
		return (int) myIdentification - (int) turtle.myIdentification;
	}

	/**
	 * Method to update the position of the turtle.
	 *
	 * @param doubel
	 *            forward : how far in current direction you should move.
	 */
	public double updatePosition(double forward) {
		double radians = toRadians(myHeading);
		double curX = forward * Math.sin(radians);
		double curY = forward * -Math.cos(radians);
		myCurrPoint = myCurrPoint.add(curX, curY);
		myNextPoint = myCurrPoint;
		myTurtlePoints.add(myNextPoint);
		getmyCurr();
		return Math.abs(forward);
	}

	/**
	 * Method to return the point the current
	 */
	public void getmyCurr() {
		myCurrPoint = myTurtlePoints.get(myTurtlePoints.size() - 1);
	}

	/**
	 * Method to set pen size.
	 *
	 * @param double size : sets pen size by setting it in pen
	 */
	public double setPenSize(double size) {
		myPen.updateSize(size);
		return size;
	}

	/**
	 * Method to set whether the line is dashed or solid.
	 *
	 * @param double dash : whether or not line is dashed.
	 */
	public double setPenDash(double dash) {
		myPen.updateDash(dash);
		return dash;
	}

	/**
	 * Method to convert degrees to radians.
	 *
	 * @param degrees
	 *            : the degrees that should be converted
	 */
	private double toRadians(double degrees) {
		return degrees * PI / 180.0;
	}

	/**
	 * Method to update the heading of the turtle.
	 *
	 * @param double degree : double of what should be added to current heading.
	 */
	public double updateHeading(double degree) {
		myHeading += degree;
		myHeading = myHeading % 360;
		return degree;
	}

	/**
	 * Method to return current heading.
	 */
	public double getHeading() {
		return myHeading;
	}

	/**
	 * Method to set heading to a specific angle.
	 *
	 * @param double degree : what it should be set to.
	 */
	public double setHeading(double degree) {
		double toReturn = degree - myHeading;
		myHeading = degree;
		return toReturn;
	}

	/**
	 * Method to make the turtle face a given point.
	 *
	 * @param x
	 *            ,y : two doubles representing x and y coordinates.
	 */
	public double towards(double x, double y) {
		getmyCurr();
		double oldHeading = myHeading;
		if (x == y && x == 0) {
			myHeading = 0;
			return oldHeading;
		} else {
			double deltaX = x - myCurrPoint.getX();
			double deltaY = y - myCurrPoint.getY();
			double newHeading = Math.atan(deltaY / deltaX);
			myHeading = -1.0 * newHeading * RADIANS_TO_DEGREES
					+ MYHEADING_CONVERSION_CONSTANT;
			if (deltaX < 0 && deltaY < 0) {
				myHeading += 180.0;
			}
			if (deltaY > 0 && deltaX < 0) {
				myHeading += 180.0;
			}
			return oldHeading - newHeading;
		}
	}

	/**
	 * Method to set x and y coordinates of a turtle.
	 *
	 * @param x
	 *            ,y : doubles representing x and y coordinates.
	 */
	public double setXAndY(double x, double y) {
		getmyCurr();
		double curX = myCurrPoint.getX();
		double curY = myCurrPoint.getY();
		// did this so i could have it done before i reset myPoint just to be
		// safe
		double root = Math.sqrt((x - curX) * (x - curX) + (y - curY)
				* (y - curY));
		myCurrPoint = new Point2D(x, y);
		myTurtlePoints.add(myCurrPoint);
		getmyCurr();
		return root;
	}

	/**
	 * Method to change whether the pen is up or down.
	 *
	 * @param pen
	 *            : double representing whether the pen is up or down.
	 */
	public double changePen(double pen) {
		if (pen == 1.0 || pen == 0.0) {
			myPen.setPenStatus(pen);
		}
		return myPen.getStatus();
	}

	/**
	 * Method to set the color of the pen.
	 *
	 * @param red
	 *            , green, blue : doubles representing the value of red,green,
	 *            blue that should be in the new color.
	 */
	public double setPenColor(double red, double green, double blue) {
		return myPen.updateColor(red, green, blue);
	}

	/**
	 * Method to change visibilty of turtle.
	 *
	 * @param visible
	 *            : double representing visibility of turtle.
	 */
	public double changeVisibility(double visible) {
		if (visible == 1.0 || visible == 0.0) {
			isShowing = visible;
		}
		return isShowing;
	}

	/**
	 * Method to return where the turtle is going to be in the future.
	 */
	public Point2D getNewLocation() {
		return myTurtlePoints.get(myTurtlePoints.size() - 1);
	}

	/**
	 * Method to return where the turtle was one step before
	 */
	public Point2D getPrevLocation() {
		if (myTurtlePoints.size() > 2) {
			return myTurtlePoints.get(myTurtlePoints.size() - 2);
		}
		return myFirstPoint;
	}

	/**
	 * Method to get the status of the pen
	 */
	public double getPenStatus() {
		return myPen.getStatus();
	}

	/**
	 * Method to get the size of the pen
	 */
	public double getPenSize() {
		return myPen.getSize();
	}

	/**
	 * Method to get whether the pen is dashed or solid
	 */
	public double getPenDash() {
		return myPen.getDash();
	}

	/**
	 * Method to see if the turtle is showing
	 */
	public double getShowing() {
		return isShowing;
	}

	/**
	 * Method to set the shape of the turtle
	 */
	public double setShape(double shapeID) {
		myShapeIdentification = shapeID;
		return shapeID;
	}

	/**
	 * Method to get the shape of the turtle
	 */
	public double getShape() {
		return myShapeIdentification;
	}

	/**
	 * Method to get the color of the pen
	 */
	public Color getPenColor() {
		return myPen.getPenColor();
	}

	/**
	 * Method to get the ID of the turtle
	 */
	public double getID() {
		return myIdentification;
	}

	/**
	 * Method to set the status of the pen param@ d : double representing
	 * whether the pen is showing
	 */
	public void setPenStatus(double d) {
		isShowing = d;

	}

	/**
	 * Method to return a map containing various stats of the turtle
	 */
	public Map getStats() {
		Map<String, Double> toReturn = new HashMap<String, Double>();
		toReturn.put("X-Coordinate", myCurrPoint.getX());
		toReturn.put("Y-Coordinate", myCurrPoint.getY());
		toReturn.put("Pen Status", isShowing);
		toReturn.put("Heading", myHeading);
		toReturn.put("ID", myIdentification);
		return toReturn;
	}
}
