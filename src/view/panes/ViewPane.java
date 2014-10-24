package view.panes;

import java.util.ArrayList;
import java.util.List;

import view.Draw;
import model.Turtle;
import javafx.geometry.Point2D;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import view.Constants;

/**
 * Responsible for drawing the graphical representation of the turtles movement
 * as its state changes using Observable. Calls on the Draw class to update the
 * graphical representation stored in View when the status of a turtle changes.
 *
 * @author Team 14
 *
 */
public class ViewPane extends PaneModule {
  
    public boolean gridVisible = true;
    public Color backColor;
    private Pane myPane = new Pane();
    private Draw myDraw = new Draw();
    private Point2D myCurrentPoint = new Point2D(0, 0);
    private List<Line> myGrid = new ArrayList<Line>();
    private Color defColor = Color.LIGHTGRAY;
    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPane () {
    	myPane.setStyle("-fx-background-color: white;");
    	myPane.setPrefSize(Constants.DEFAULT_DIMENSION,Constants.DEFAULT_DIMENSION);
    	myPane.getChildren().add(myDraw.figure);
    	createGrid(defColor);
    }

    public void updateView (Turtle t) {
    	
    	myDraw.drawLine(myCurrentPoint,t.getLocation());
        myPane.getChildren().add(myDraw.path);
        myCurrentPoint = t.getLocation();
        myDraw.setAngle(t.getHeading());
   		myDraw.moveTurtle(myCurrentPoint);
    }

   
    @Override
    public BorderPane addPane (BorderPane p) {
        p.setCenter(myPane);
        return p;
    }

	public void showError(String displayMessage) {
		System.out.println(displayMessage);
	}
	
	private void createGrid(Color c){
		int loc = 0;
		int cellSize = 10;
		while(loc < Constants.DEFAULT_DIMENSION - 10){
				Line horizontal = new Line (0, loc, Constants.DEFAULT_DIMENSION -10, loc);
				myGrid.add(horizontal);
				Line vertical = new Line (loc, 0, loc, Constants.DEFAULT_DIMENSION);
				myGrid.add(vertical);
			loc += cellSize;
		}
		for (Line l : myGrid){
			l.setStroke(c);
			l.toBack();
			myPane.getChildren().add(l);
		}
	}
	public void changeGridVisibility(){
		if (gridVisible != true){
				
				myPane.getChildren().remove(myGrid);
			
		}
		else{
		createGrid(defColor);
		}
		gridVisible = !gridVisible;
		System.out.println(gridVisible);
	}	
}
