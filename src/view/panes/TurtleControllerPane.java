package view.panes;

import java.io.File;

import view.CommandString;
import view.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

public class TurtleControllerPane extends PaneModule {
	private VBox myVbox = new VBox();
	private TextField myMoveTextField = new TextField();
	private TextField myAngleTextField = new TextField();
	private CommandString myCommandString;

	/**
	 * Initializes the parameters of the InputPane.
	 *
	 * @param cs
	 *            CommandString containing the String that represents the
	 *            current command
	 */
	public TurtleControllerPane(CommandString cs) {
		myCommandString = cs;
		myMoveTextField.setPrefColumnCount(5);
		Button moveButton = makeButton("Forward", event -> move());
		myAngleTextField.setPrefColumnCount(5);
		Button angleButton = makeButton("Right (deg)", event -> angle());
		Button chooseFileButton = makeButton("Choose Image",
				event -> doChoose());
		myVbox.getChildren().addAll(new Label("Turtle Prop."),
				chooseFileButton, new Separator(),
				new Label("Turtle Commands"), myAngleTextField, angleButton,
				myMoveTextField, moveButton,
				new PenPane(myCommandString).getPenPane());
		myVbox.setOnKeyPressed(new MoveHandler());
	}

	private Button makeButton(String property, EventHandler<ActionEvent> handler) {
		Button result = new Button();
		String label = property;
		result.setText(label);
		result.setOnAction(handler);
		return result;
	}

	private void move() {
		if (!myMoveTextField.getText().equals("")) {
			myCommandString.setCommand("Forward " + myMoveTextField.getText(),
					Constants.SETTING);
			myMoveTextField.clear();
		}
	}

	private void angle() {
		if (!myAngleTextField.getText().equals("")) {
			myCommandString.setCommand("Right " + myAngleTextField.getText(),
					Constants.SETTING);
			myAngleTextField.clear();
		}
	}

	private void doChoose() {
		final Label labelFile = new Label();
		FileChooser fileChooser = new FileChooser();
		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"Image Files (*.png)", "*.png");
		fileChooser.getExtensionFilters().add(extFilter);
		// Show open file dialog
		File file = fileChooser.showOpenDialog(null);
		labelFile.setText(file.getPath());
	}

	@Override
	public BorderPane addPane(BorderPane p) {
		p.setLeft(myVbox);
		return p;
	}

	private void move(int orientation) {
		myCommandString.setCommand("setheading " + orientation, 0);
		myCommandString.setCommand("forward 20", 0);
	}

	private class MoveHandler implements EventHandler<KeyEvent> {
		int orientation = 0;

		@Override
		public void handle(KeyEvent event) {
			if (event.getCode() == KeyCode.W) {
				orientation = Constants.UP;
			} else if (event.getCode() == KeyCode.D) {
				orientation = Constants.RIGHT;
			} else if (event.getCode() == KeyCode.S) {
				orientation = Constants.DOWN;
			} else if (event.getCode() == KeyCode.A) {
				orientation = Constants.LEFT;
			}
			move(orientation);
		}
	}
}
