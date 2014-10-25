package model;

import javafx.scene.paint.Color;

public class Pen {
	private Color myColor;
	private double mySize;
	private double myDash;
	private double isPenDown;

	public Pen() {
		mySize = 1.0;
		myColor = Color.BLUE;
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
	
	
	protected void updateColor(Color color) {
		myColor = color;
	}

	protected Color getColor() {
		return myColor;
	}

	protected double setPenStatus(double status) {
		isPenDown = status;
		return status;
	}

	protected double getStatus() {
		return isPenDown;
	}
}