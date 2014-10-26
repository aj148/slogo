package view.panes;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import view.CommandString;

public class TurtleStatsPane {
	 private VBox myVbox = new VBox();
	 private Map<String,Double> map = new HashMap<String,Double>();

	    public TurtleStatsPane () {
	    	map = turtle.getStats();
	    	map.forEach()
	        myVbox.getChildren().addAll();

	    }
	    
	    public VBox getTurtleStatsPane(){
	    	return myVBox;
	    }
	    
	    public Label LabelMaker
}
