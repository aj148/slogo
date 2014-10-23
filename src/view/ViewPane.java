package view;

import java.util.List;
import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Turtle;


/**
 * Responsible for drawing the graphical representation of the turtles movement as its state changes
 * using Observable. Calls on the Draw class to update the graphical representation stored in View
 * when the status of a turtle changes.
 *
 * @author Team 14
 *
 */
public class ViewPane extends PaneModule {
    public static final int DEFAULT_DIMENSION = 500;
    private Pane myPane = new Pane();
    private Draw myDraw = new Draw();
    private Point2D myCurrentPoint = new Point2D(0, 0);
    private List<Line> myGrid = new ArrayList<Line>();
    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPane () {
    	myPane.setStyle("-fx-background-color: white;");
    	myPane.setPrefSize(DEFAULT_DIMENSION,DEFAULT_DIMENSION);
    	
    	createGrid();
    }

    public void updateView (Turtle t) {
    	
    	myDraw.drawLine(myPane,myCurrentPoint,t.getLocation());
        myPane.getChildren().add(myDraw.figure);
       myCurrentPoint = t.getLocation();
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setCenter(myPane);
        return p;
    }

	public void showError(String displayMessage) {
		System.out.println(displayMessage);
	}
	
	private void createGrid(){
		int loc = 0;
		int cellSize = 10;
		while(loc < DEFAULT_DIMENSION){
				Line horizontal = new Line (0, loc, DEFAULT_DIMENSION, loc);
				myGrid.add(horizontal);
				Line vertical = new Line (loc, 0, loc, DEFAULT_DIMENSION);
				myGrid.add(vertical);
			loc += cellSize;
		}
		for (Line l : myGrid){
			l.setStroke(Color.LIGHTGRAY);
			l.toBack();
			myPane.getChildren().add(l);
		}
	}}
