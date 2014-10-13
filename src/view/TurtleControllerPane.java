package view;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


public class TurtleControllerPane extends Pane {
    private VBox myVbox = new VBox();
    private TextField myMoveTextField = new TextField();
    private TextField myAngleTextField = new TextField();
    private CommandString myCommandString;

    /**
     * Initializes the parameters of the InputPane.
     *
     * @param cs CommandString containing the String that represents the current command
     */
    public TurtleControllerPane (CommandString cs) {
        myCommandString = cs;
        myMoveTextField.setPrefColumnCount(5);
        Button moveButton = makeButton("Forward", event -> move());
        myAngleTextField.setPrefColumnCount(5);
        Button angleButton = makeButton("Right (deg)", event -> angle());
        Button chooseFileButton = makeButton("Choose Image", event -> doChoose());
        myVbox.getChildren().addAll(chooseFileButton, myAngleTextField, angleButton,
                                    myMoveTextField, moveButton);
    }

    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

    private void move () {
        myCommandString.setCommand("Forward " + myMoveTextField.getText(), Constants.SETTING);
        myMoveTextField.clear();
    }

    private void angle () {
        myCommandString.setCommand("Right " + myAngleTextField.getText(), Constants.SETTING);
        myAngleTextField.clear();

    }

    private void doChoose () {
        final Label labelFile = new Label();
        FileChooser fileChooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("Image Files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        // Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        labelFile.setText(file.getPath());
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setLeft(myVbox);
        return p;
    }

}
