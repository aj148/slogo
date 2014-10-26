package view.panes;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import view.CommandString;
import view.Constants;
import view.controllers.ImagePalette;

/**
 * Allows the GUI control over turtles
 * 
 * @author Team 14
 *
 */
public class TurtleControllerPaneModule extends PaneModule {
    private VBox myVbox = new VBox();
    private TextField myMoveTextField = new TextField();
    private TextField myAngleTextField = new TextField();
    private TextField myIDTextField = new TextField("0");
    private CommandString myCommandString;
    private TurtleSelectorPane myTurtles;;
    private Set<Integer> myActiveTurtles = new HashSet<Integer>();
    private Map<Integer, String> myImages = new HashMap<Integer, String>();
    private ImagePalette myImagePalette;
    private HBox myImageBar = new HBox();
    private PenPane myPenPane;

    /**
     * Initializes the parameters of the InputPane.
     *
     * @param cs
     *            CommandString containing the String that represents the
     *            current command
     */
    public TurtleControllerPaneModule (CommandString cs, ImagePalette ip, ViewPaneModule vp) {
        myCommandString = cs;
        myTurtles = new TurtleSelectorPane(myCommandString, vp);
        myImagePalette = ip;
        myPenPane = new PenPane(myCommandString);
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
                myPenPane.getPenPane(), myTurtles.getPane());

        myVbox.setOnKeyPressed(new MoveHandler());
        makeTurtle();
        myIDTextField.clear();
    }

    /**
     * Makes a new ImageSelector System
     * 
     * @return HBox containing image selector items
     */
    private HBox imageSelectorMaker () {
        Button chooseFileButton = makeButton("Add Image", event -> doChoose());
        myImageBar.getChildren().addAll(myImagePalette.getBox(), chooseFileButton);
        return myImageBar;
    }

    /**
     * Button Factory
     * 
     * @param property
     *            String label for button
     * @param handler
     *            EventHandler for the button
     * @return Completed Button
     */
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

    /**
     * Defines the behavior for when a File Chooser is used to select a new
     * image to be added to the Image Palette
     */
    private void doChoose () {
        new Label();
        FileChooser fileChooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Image Files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        // Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String fileName = file.getName();
        String filePath = file.getPath().replace("\\", "/");
        myImagePalette.addImage(filePath, fileName);
    }

    /**
     * Moves the turtle using the GUI
     */
    private void move () {
        if (!myMoveTextField.getText().equals("")) {
            myCommandString.setCommand("Forward " + myMoveTextField.getText(), Constants.SETTING);
            myMoveTextField.clear();
        }
    }

    /**
     * Sets the Orientation of the turtle using the GUI
     */
    private void angle () {
        if (!myAngleTextField.getText().equals("")) {
            myCommandString.setCommand("Right " + myAngleTextField.getText(), Constants.SETTING);
            myAngleTextField.clear();
        }
    }

    /**
     * Adds the pane to the BorderPane
     */
    @Override
    public BorderPane addPane (BorderPane p) {
        p.setLeft(myVbox);
        return p;
    }

    /**
     * Makes a new turtle with a user defined ID number and turtle image using
     * the GUI
     */
    private void makeTurtle () {
        if (!myIDTextField.getText().equals("")) {
            int id = Integer.parseInt(myIDTextField.getText());
            myTurtles.newTurtle(id);
            myIDTextField.clear();
            myCommandString.setCommand("Tell [ " + Integer.toString(id) + " ]", Constants.SETTING);
            myCommandString.setCommand("SETSHAPE " + myImagePalette.getCurrentImageID(),
                    Constants.SETTING);
            myPenPane.newTurtle();
        }
    }

    /**
     * Works with the MoveHandler to move a turtle using the WASD keys
     * 
     * @param orientation
     *            Int representing the direction of movement
     */
    private void move (int orientation) {
        myCommandString.setCommand("setheading " + orientation, 0);
        myCommandString.setCommand("forward 5", 0);
    }

    /**
     * Event Handler that allows for movement of the turtle using the WASD keys
     * 
     * @author Team 14
     *
     */
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
