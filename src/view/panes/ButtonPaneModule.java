package view.panes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.CommandString;
import view.Constants;
import view.controllers.LanguageController;

public class ButtonPaneModule extends PaneModule {
    private final ToolBar myToolBar = new ToolBar();
    private ComboBox<Button> myComboBox = new ComboBox<Button>();
    private VBox myVbox = new VBox();
    private HBox myHbox = new HBox();
    private CommandString myCommandString;
    private String myCurrent;
    private ColorPicker myColorPicker;
    private LanguageController myLanguageController;
    private ViewPaneModule myView;

    public ButtonPaneModule (CommandString cs, LanguageController ls, ViewPaneModule vs) {
        myCommandString = cs;
        myLanguageController = ls;
        myView = vs;
        createPropertiesMenu();
    }

    public void createPropertiesMenu () {
        myColorPicker = makeColorPicker("Background Color", event -> backgroundColor());
        Button toggleReferenceGrid = makeButton("Toggle Grid", event -> toggleGrid());
        Button help = makeButton("Help", event -> help());
        myHbox.getChildren().addAll(new Label("Background"), myColorPicker, toggleReferenceGrid,
                myLanguageController.makeMenu(), help);
        myToolBar.getItems().add(myHbox);
        myVbox.getChildren().add(myToolBar);
        WorkspaceTabs workspace = new WorkspaceTabs();
        myVbox.getChildren().add(workspace.getWorkspace());
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setTop(myVbox);
        return p;
    }

    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

    
    private ColorPicker makeColorPicker (String property, EventHandler<ActionEvent> handler) {
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
    	myView.changeGridVisibility();
    }

    public void changeColor (String myType) {
        Color c = myColorPicker.getValue();
        System.out.println("New Color's RGB = " + c.getRed() + " " + c.getGreen() + " "
                + c.getBlue());
        myCurrent = myType + c.toString();
        myCommandString.setCommand(myCurrent, Constants.SETTING);
        System.out.println(myCurrent);
    }

    public void help () {
        String url = Constants.HELP_URL;
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        } catch (IOException e) {
            System.out.println("IO Exception When Opening Help Page");
        } catch (URISyntaxException e) {
            System.out.println("Help Page URL Formatted Incorrectly");
        }
    }
}
