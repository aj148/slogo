package view.panes;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import view.CommandString;
import view.Constants;
import view.Factory;

/**
 * Subclass of Pane that implements a scrollable textfield that allows for user
 * input. Hitting enter or hitting the submit button pushes the command inputed
 * by the user.
 *
 * @author Team14
 * 
 * This is my Masterpiece.
 * Arihant Jain
 *
 */

public class InputPaneModule extends PaneModule {
    private HBox myHBox = new HBox();
    private ScrollPane myScrollPane = new ScrollPane();
    private TextField myTextField = new TextField();
    private CommandString myCommandString;

    /**
     * Initializes the parameters of the InputPane.
     *
     * @param cs
     *            CommandString containing the String that represents the
     *            current command
     */
    public InputPaneModule (CommandString cs) {
        myCommandString = cs;
        myScrollPane.setContent(myTextField);
        myTextField.setPrefColumnCount(70);
        myTextField.setOnKeyPressed(new SubmitHandler());
        Button submit = new Factory().makeButton("Submit", event -> submit());
        Button save = new Factory().makeButton("Submit", event -> submit());

        myHBox.getChildren().addAll(myScrollPane, submit, save);
    }

    /**
     * Submits the current command by updating the CommandString with the String
     * contained by the TextField. Then clear the field in preparation for the
     * next command.
     */
    private void submit () {
        if (!myTextField.getText().equals("")) {
            myCommandString.setCommand(myTextField.getText(), Constants.COMMAND);
            myTextField.clear();
        }
    }

    /**
     * Saves the current command as a user defined command for future use by
     * update the CommandString with the String contained by the TextField.
     */
    private void save () {
        if (!myTextField.getText().equals("")) {
            myCommandString.setCommand(myTextField.getText(), Constants.USER_DEFINE);
            myTextField.clear();
        }

    }

    /**
     * Adds the pane to the BorderPane
     */
    @Override
    public BorderPane addPane (BorderPane p) {
        p.setBottom(myHBox);
        return p;
    }

    /**
     * EventHandler which submits the command input when the enter key is
     * pressed.
     *
     * @author Team 14
     *
     */
    private class SubmitHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle (KeyEvent event) {
            if (event.getCode() == KeyCode.ENTER) {
                submit();
            }
        }
    }
}
