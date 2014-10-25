package model;

import javafx.scene.paint.Color;

public class Pen {
	private Color myColor;
	private double mySize;
	private double myDash;
	private double isPenDown;

	public Pen() {
		mySize = 1.0;
		myColor = Color.BLACK;
		myDash = 1;
	}

	protected double updateSize(double newSize) {
		mySize = newSize;
		return newSize;
	}

	protected double getSize() {
		return mySize;
	}
	
	protected double getDash(){
		return myDash;
	}
	
	protected double updateColor(double red, double green, double blue) {
		myColor = Color.rgb((int)red, (int)green, (int)blue);
		return red + (1000 * green) + (1000000 * blue);
	}

	protected double getColor() {
		double red = myColor.getRed() * 255;
		double green = myColor.getGreen() * 255000;
		double blue = myColor.getBlue() * 255000000;
		return red + green + blue;
	}

	protected double setPenStatus(double status) {
		isPenDown = status;
		return status;
	}

	protected double getStatus() {
		return isPenDown;
	}
}