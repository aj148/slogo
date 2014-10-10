package view;

import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;



public class InputPane extends Pane {

    private HBox myHBox;
    private ScrollPane myScrollPane;
    private TextField myTextField;
    private String myCurrent;
    private CommandString myCommandString;


    public InputPane (CommandString cs) {
        myCurrent = "";
        myCommandString = cs;
        myHBox = new HBox();
        myScrollPane = new ScrollPane();
        myTextField = new TextField();
        myScrollPane.setContent(myTextField);
        myTextField.setPrefColumnCount(60);
        Button submit = new Button("Submit");
        submit.setOnAction(event -> submit());
     
    }

    private void submit () {
        myCurrent = myTextField.getText();
        myCommandString.setCommand(myCurrent);
        System.out.println(myCurrent);
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

}
