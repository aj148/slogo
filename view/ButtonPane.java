package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class ButtonPane extends Pane {

    private final ToolBar myToolBar;
    private ComboBox myComboBox;
    private Button backgroundColorButton;
    private Button penColorButton;
    private CommandString myCommandString;
    private String myCurrent;
    
    
    public ButtonPane () {
        myToolBar = new ToolBar();
        createPropertiesMenu();
    }

    public void createPropertiesMenu () {
        ComboBox myComboBox = new ComboBox();
        
        backgroundColorButton = makeButton("Background Color", event -> backgroundColor());
        penColorButton = makeButton("Pen Color", event -> changePenColor());
        myComboBox.getItems().addAll(backgroundColorButton, penColorButton);
        myToolBar.getItems().add(myComboBox);
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setTop(myToolBar);
        return p;
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

    
    

    public void backgroundColor(){
    	myCurrent = "black";
    	myCommandString.setCommand(myCurrent);
        System.out.println(myCurrent);
    	
    }
    public void changePenColor(){
    	System.out.println("black");
    	
    }
    
}
