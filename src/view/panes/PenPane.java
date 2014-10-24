package view.panes;

import view.CommandString;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PenPane {
	private VBox myVbox = new VBox();
	private CommandString myCommandString;
	private CheckBox myPenToggle = new CheckBox("Toggle Pen");
	private ColorPicker myColorPicker;
	private ChoiceBox myPenStyles = new ChoiceBox();

	public PenPane(CommandString cs) {
		myCommandString = cs;
		myColorPicker = makeColorPicker("Pen Color", event -> changePenColor());

		myVbox.getChildren().addAll(new Separator(), new Label("Pen Commands"),
				myPenToggle, new Label("Pen Color"), myColorPicker,
				new Label("Pen Style"), myPenStyles);

	}

	public VBox getPenPane() {
		return myVbox;
	}

	private ColorPicker makeColorPicker(String property,
			EventHandler<ActionEvent> handler) {
		ColorPicker result = new ColorPicker();
		result.setOnAction(handler);
		result.getStyleClass().add("split-button");
		result.setPromptText(property);
		return result;
	}

	public void changePenColor() {
		Color c = myColorPicker.getValue();
		String cur = "SETSHAPE " + c.getRed() + " " + c.getGreen() + " "
				+ c.getBlue();
		myCommandString.setCommand(cur, 0);
	}

}
