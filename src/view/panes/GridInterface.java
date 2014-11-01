package view.panes;
import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.Constants;

/**
 * @author Arihant Jain
 * This interface creates a grid.
 * 
 * 
 * This is my Masterpiece.
 * Arihant Jain
 *
 */
public interface GridInterface {
	
	/**
	 * Creates Grid
	 * 
	 * @param p - Takes in a pane
	 * @param cellSize - For width and height of cell
	 * @param c - Color of grid.
	 * @return
	 */
	static ArrayList<Line> createGrid(Pane p, int cellSize, Color c){
		ArrayList<Line> myGrid = new ArrayList<Line>();
		int loc = 0;
		while(loc < Constants.VIEW_DEFAULT_DIMENSION){
			Line horizontal = new Line(0, loc, Constants.VIEW_DEFAULT_DIMENSION - 10, loc);
            myGrid.add(horizontal);
            Line vertical = new Line(loc, 0, loc, Constants.VIEW_DEFAULT_DIMENSION);
            myGrid.add(vertical);
            loc += cellSize;
		}
		for (Line l : myGrid){
			l.setStroke(c);
			l.toBack();
			p.getChildren().add(l);
		}
		return myGrid;
	}
}
