package model;

import javafx.scene.paint.Color;

/**
 * Class the contains the pen information, instantiated for each turtle because
 * each turtle can have different pen information
 */
public class Pen {
	private static final int BLUE_CONSTANT = 255000000;
	private static final int GREEN_CONSTANT = 255000;
	private static final int RED_CONSTANT = 255;
	private Color myColor;
	private double mySize;
	private double myDash;
	private double isPenDown;

	public Pen() {
		mySize = 1.0;
		myColor = Color.BLACK;
		myDash = 1;
	}

	/**
	 * Method to update the size of the pen.
	 *
	 * @param double newSize : new size pen should be
	 */
	protected double updateSize(double newSize) {
		mySize = newSize;
		return newSize;
	}

	/**
	 * Method to update whether the line is solid or dashed.
	 *
	 * @param double newDash : tells you whether or not the line is dashed
	 */
	protected double updateDash(double newDash) {
		myDash = newDash;

		return newDash;
	}

	/**
	 * Method to return the size of the pen to the Turtle the pen is contained
	 * in
	 */
	protected double getSize() {
		return mySize;
	}

	/**
	 * Method to return whether or not the line is dashed to the turtle the pen
	 * is contained in
	 */
	protected double getDash() {
		return myDash;
	}

	/**
	 * Method to update the color of the pen.
	 *
	 * @param red
	 *            , blue, green: amount of red, blue, green in the new color
	 */
	protected double updateColor(double red, double green, double blue) {
		int r = (int) (255 * red);
		int g = (int) (255 * green);
		int b = (int) (255 * blue);
		myColor = Color.rgb(r, g, b);
		return red + (1000 * green) + (1000000 * blue);
	}

	/**
	 * Method to return the Color of the pen to the turtle in which the pen is
	 * contained in the form of a double that can be easily interpreted.
	 */
	protected double getColor() {
		double red = myColor.getRed() * RED_CONSTANT;
		double green = myColor.getGreen() * GREEN_CONSTANT;
		double blue = myColor.getBlue() * BLUE_CONSTANT;
		return red + green + blue;
	}

	/**
	 * Method to return the Color of the pen to the turtle as a color.
	 */
	protected Color getPenColor() {
		return myColor;
	}

	/**
	 * Method to set whether or not the pen is down.
	 *
	 * @param status
	 *            : double that indicates whether the pen is up or not.
	 */
	protected double setPenStatus(double status) {
		isPenDown = status;
		return status;
	}

	/**
	 * Method to return to the turtle whether or not the pen is up.
	 */
	protected double getStatus() {
		return isPenDown;
	}
}
