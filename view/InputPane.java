package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



/**
 * Subclass of Pane that implements a scrollable textfield that allows for user input. Hitting enter
 * or hitting the submit button pushes the command inputed by the user.
 * 
 * @author Team14
 *
 */

public class InputPane extends Pane {

    private HBox myHBox = new HBox();
    private ScrollPane myScrollPane = new ScrollPane();
    private TextField myTextField = new TextField();
    private CommandString myCommandString;


    /**
     * Initializes the parameters of the InputPane.
     * 
     * @param cs CommandString containing the String that represents the current command
     */

    public InputPane (CommandString cs) {
        myCommandString = cs;
        myScrollPane.setContent(myTextField);
        myTextField.setPrefColumnCount(60);
        myTextField.setOnKeyPressed(new SubmitHandler());
        Button submit = new Button("Submit");
        submit.setOnAction(event -> submit());
     
    }

    /**
     * Submits the current command by updating the CommandString with the String contained by the
     * TextField. Then clear the field in preparation for the next command.
     */
    private void submit () {
        if (!myTextField.getText().equals("")) {
            myCommandString.setCommand(myTextField.getText());
            myTextField.clear();
        }
    }
   
    
    // makes a button using either an image or a label
 	/**
 	 * @param property
 	 * @param handler
 	 * @return Button 
 	 */
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
 		Button result = new Button();
 		String label = property;
 		result.setText(label);
 		result.setOnAction(handler);
 		return result;
 	}

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setBottom(myHBox);
        return p;
    }

    /**
     * EventHandler which submits the command input when the enter key is pressed.
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
