package view.panes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.CommandString;
import view.Constants;
import model.Pen;

public class PenPane {
	private VBox myVbox = new VBox();
	private CommandString myCommandString;
	private CheckBox myPenToggle = new CheckBox("Toggle PenUp");
	private ColorPicker myColorPicker;
	private ChoiceBox myPenStyles = new ChoiceBox();
	private TextField myPenWidth = new TextField("Insert double");
	private final static String[] PENSTYLE = new String[] { "Normal", 
		"Thick", "Thicker", "Thickest","Dashed", "Dotted" };

	public PenPane (CommandString cs) {
		myCommandString = cs;
		myColorPicker = makeColorPicker("Pen Color", event -> changePenColor());
		myPenStyles = makeMenu();
		myVbox.getChildren().addAll(new Separator(), new Label("PEN COMMANDS"), myPenToggle,
				new Label("Pen Color"), myColorPicker, new Label("Pen Style"), myPenStyles,
				new Label("Pen Width"), myPenWidth);

	}

	public VBox getPenPane () {
		return myVbox;
	}

	public void setPenStyle(int i){
		if(i<4){
			myCommandString.setCommand("SETPENSIZE " + Integer.toString(i),Constants.SETTING);
		}
		else{
//			myCommandString.setCommand("SETPENDASH " + Integer.toString(i),Constants.SETTING);
			// Change active turtle's pen set dash  			
		}

				

	}



	private ColorPicker makeColorPicker (String property, EventHandler<ActionEvent> handler) {
		ColorPicker result = new ColorPicker();
		result.setOnAction(handler);
		result.getStyleClass().add("split-button");
		result.setPromptText(property);
		return result;
	}

	public ChoiceBox makeMenu () {
		ChoiceBox penStyles = new ChoiceBox(FXCollections.observableArrayList("Normal", "Thick", 
				"Thicker","Dashed","Dotted"));
		penStyles.getSelectionModel().selectedIndexProperty()
		.addListener(new ChangeListener<Number>() {
			public void changed (ObservableValue ov, Number value, Number new_value) {
				setPenStyle(new_value.intValue());
			}
		});
		return penStyles;
	}

	public void changePenColor () {
		Color c = myColorPicker.getValue();
		String cur = "SETSHAPE " + c.getRed() + " " + c.getGreen() + " " + c.getBlue();
		myCommandString.setCommand(cur, 0);
	}

}
