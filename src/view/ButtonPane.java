package view;



import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;


public class ButtonPane extends Pane {

    private final ToolBar myToolBar = new ToolBar();
    private ComboBox<Button> myComboBox = new ComboBox();
    private HBox myHbox = new HBox();
    private Button toggleReferenceGrid;
    private Button Help;
    private Button myChooseFileButton;
    private CommandString myCommandString;
    private String myCurrent;
    private ColorPicker colorPicker;
    private File file;
    private ColorPicker colorPicker2;

    public ButtonPane (CommandString cs) {
        myCommandString = cs;
        createPropertiesMenu();
    }

    public void createPropertiesMenu () {
        colorPicker = makeColorPicker("Background Color", event -> backgroundColor());
        
        colorPicker2 = makeColorPicker("Pen Color", event -> changePenColor());
        toggleReferenceGrid = makeButton("Toggle Grid", event -> toggleGrid());
        Help = makeButton("Help", event -> help());
        myChooseFileButton = makeButton("Choose Image",event -> doChoose());
        myHbox.getChildren().addAll(colorPicker,colorPicker2,toggleReferenceGrid,Help,myChooseFileButton);
        myToolBar.getItems().add(myHbox);
    }
    

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setTop(myToolBar);
        return p;
    }

    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }
    
    private void doChoose() {
    	final Label labelFile = new Label();
		FileChooser fileChooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        //Show open file dialog
        file = fileChooser.showOpenDialog(null);
        labelFile.setText(file.getPath());
    }
    private ColorPicker makeColorPicker(String property, EventHandler<ActionEvent> handler){
    	ColorPicker result = new ColorPicker();
        result.setOnAction(handler);
        result.getStyleClass().add("split-button");
        result.setPromptText(property);
        return result;
    }

    public void backgroundColor () {
        String myType = "Background Color ";
    	changeColor(myType);

    }
    public void toggleGrid(){
    	
    }

    public void changePenColor () {
    	    	
    	String myType = "Pen Color ";
        changeColor(myType);

    }
    
    public void changeColor(String myType){
    	 Color c = colorPicker.getValue();
         System.out.println("New Color's RGB = "+c.getRed()+" "+c.getGreen()+" "+c.getBlue());      
         myCurrent = myType + c.toString();
         myCommandString.setCommand(myCurrent,0);
         System.out.println(myCurrent);
    }
    public void help(){
    	
    }
}
