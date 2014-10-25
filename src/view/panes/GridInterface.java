package view.panes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import view.Constants;

public interface GridInterface {
	private void createGrid (Color c) {
		int loc = 0;
		int cellSize = 10;
		while (loc < Constants.VIEW_DEFAULT_DIMENSION - 10) {
			Line horizontal = new Line(0, loc, Constants.VIEW_DEFAULT_DIMENSION - 10, loc);
			myGrid.add(horizontal);
			Line vertical = new Line(loc, 0, loc, Constants.VIEW_DEFAULT_DIMENSION);
			myGrid.add(vertical);
			loc += cellSize;
		}
		for (Line l : myGrid) {
			l.setStroke(c);
			l.toBack();
			myPane.getChildren().add(l);
		}
	}

}
