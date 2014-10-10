package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class TurtleControllerPane extends Pane {
	 	private HBox myHbox = new HBox();
	 	private TextField myMoveTextField = new TextField();
	 	private TextField myAngleTextField = new TextField();
	    private CommandString myCommandString;
	    private Button moveButton;
	    private Button angleButton;

	    /**
	     * Initializes the parameters of the InputPane.
	     *
	     * @param cs CommandString containing the String that represents the current command
	     */
	    public TurtleControllerPane (CommandString cs) {
	        myCommandString = cs;
	        myMoveTextField.setPrefColumnCount(5);
	        moveButton = makeButton("Forward", event ->move());
	        myAngleTextField.setPrefColumnCount(5);
	        angleButton = makeButton("Right (deg)", event ->angle());
	        myHbox.getChildren().addAll(myAngleTextField, angleButton, myMoveTextField, moveButton);
	    }
	 
	
	
	private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }
	
	private void move() {
		myCommandString.setCommand("Forward " + myMoveTextField.getText(), 1);
        myMoveTextField.clear();
	}

	private void angle() {
		myCommandString.setCommand("Right " + myAngleTextField.getText(), 1);
        myAngleTextField.clear();
		
	}
	
	@Override
	public BorderPane addPane(BorderPane p) {
		// TODO Auto-generated method stub
		p.setLeft(myHbox);
        return p;
	}
	

}
