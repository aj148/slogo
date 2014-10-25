package view.panes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.CommandString;
import view.Constants;
import view.controllers.LanguageController;
import view.controllers.WorkspaceTabsController;

public class ButtonPaneModule extends PaneModule {
    private final ToolBar myToolBar = new ToolBar();
    private HBox myHbox = new HBox();
    private CommandString myCommandString;
    private ColorPicker myColorPicker;
    private LanguageController myLanguageController;
    private ViewPaneModule myView;
    private VBox myVBox;

    public ButtonPaneModule (CommandString cs, LanguageController ls, ViewPaneModule vs, VBox v) {
        myCommandString = cs;
        myLanguageController = ls;
        myVBox = v;
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
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        if (myVBox.getChildren().size() == 1) {
            myVBox.getChildren().add(myToolBar);
        } else {
            myVBox.getChildren().remove(1);
            myVBox.getChildren().add(myToolBar);
        }
        p.setTop(myVBox);
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
        Color c = myColorPicker.getValue();
        myCommandString.setCommand(
                "SETBACKGROUND " + c.getRed() + " " + c.getGreen() + " " + c.getBlue(),
                Constants.SETTING);
    }

    public void toggleGrid () {
        myView.changeGridVisibility();
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
