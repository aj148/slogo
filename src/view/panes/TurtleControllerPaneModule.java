package view.panes;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import view.CommandString;
import view.Constants;
import view.controllers.ImagePalette;

public class TurtleControllerPaneModule extends PaneModule {
    private VBox myVbox = new VBox();
    private TextField myMoveTextField = new TextField();
    private TextField myAngleTextField = new TextField();
    private TextField myIDTextField = new TextField("0");
    private CommandString myCommandString;
    private TurtleSelectorPane myTurtles = new TurtleSelectorPane();
    private Set<Integer> myActiveTurtles = new HashSet<Integer>();
    private Map<Integer, String> myImages = new HashMap<Integer, String>();
    private ImagePalette myImagePalette;
    private HBox myImageBar = new HBox();

    /**
     * Initializes the parameters of the InputPane.
     *
     * @param cs
     *            CommandString containing the String that represents the
     *            current command
     */
    public TurtleControllerPaneModule (CommandString cs, ImagePalette ip) {
        myCommandString = cs;
        myImagePalette = ip;
        myMoveTextField.setPrefColumnCount(5);
        myAngleTextField.setPrefColumnCount(5);
        myIDTextField.setPrefColumnCount(5);
        Button moveButton = makeButton("Forward", event -> move());
        Button angleButton = makeButton("Right (deg)", event -> angle());
        Button makeNewTurtle = makeButton("Make New Turtle", event -> makeTurtle());

        myVbox.getChildren().addAll(new Label("TURTLE PROPERTIES"),
                new HBox(myIDTextField, new Label("ID Number")), imageSelectorMaker(),
                makeNewTurtle, new Separator(), new Label("COMMANDS"),
                new HBox(myAngleTextField, angleButton), new HBox(myMoveTextField, moveButton),
                new Label("WASD can be used with "), new Label("this pane active"),
                new PenPane(myCommandString).getPenPane(), myTurtles.getPane());

        myVbox.setOnKeyPressed(new MoveHandler());
        makeTurtle();
        myIDTextField.clear();
    }

    private HBox imageSelectorMaker () {
        Button chooseFileButton = makeButton("Add Image", event -> doChoose());
        myImageBar.getChildren().addAll(myImagePalette.getBox(), chooseFileButton);
        return myImageBar;
    }

    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

    private void doChoose () {
        final Label labelFile = new Label();
        FileChooser fileChooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Image Files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        // Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String fileName = file.getName();
        myImagePalette.addImage(file.getPath(), fileName);
    }

    private void move () {
        if (!myMoveTextField.getText().equals("")) {
            myCommandString.setCommand("Forward " + myMoveTextField.getText(), Constants.SETTING);
            myMoveTextField.clear();
        }
    }

    private void angle () {
        if (!myAngleTextField.getText().equals("")) {
            myCommandString.setCommand("Right " + myAngleTextField.getText(), Constants.SETTING);
            myAngleTextField.clear();
        }
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setLeft(myVbox);
        return p;
    }

    private void makeTurtle () {
        if (!myIDTextField.getText().equals("")) {
        	int id = Integer.parseInt(myIDTextField.getText());
            myTurtles.newTurtle(id);
            String myImage = myImagePalette.getCurrentImage();
            myIDTextField.clear();
            myCommandString.setCommand("Tell [ " + Integer.toString(id) + " ]",Constants.SETTING);
//
        }
    }

    private void move (int orientation) {
        myCommandString.setCommand("setheading " + orientation, 0);
        myCommandString.setCommand("forward 5", 0);
    }

    private class MoveHandler implements EventHandler<KeyEvent> {
        int orientation = 0;

        @Override
        public void handle (KeyEvent event) {
            if (event.getCode() == KeyCode.W) {
                orientation = Constants.UP;
                move(orientation);
            } else if (event.getCode() == KeyCode.D) {
                orientation = Constants.RIGHT;
                move(orientation);
            } else if (event.getCode() == KeyCode.S) {
                orientation = Constants.DOWN;
                move(orientation);
            } else if (event.getCode() == KeyCode.A) {
                orientation = Constants.LEFT;
                move(orientation);
            }
        }
    }
}
