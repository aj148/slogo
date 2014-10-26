package view.panes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.CommandString;
import view.Constants;
import view.controllers.LanguageController;

/**
 * Pane containing the ToolBar of Buttons allowing for function setting
 * 
 * @author Team 14
 *
 */
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

    /**
     * Creates the Toolbar of Buttons that allow for Properties adjustment
     */
    public void createPropertiesMenu () {
        myColorPicker = makeColorPicker("Background Color", event -> backgroundColor());
        Button toggleReferenceGrid = makeButton("Toggle Grid", event -> toggleGrid());
        Button help = makeButton("Help", event -> help());
        myHbox.getChildren().addAll(new Label("Background"), myColorPicker, toggleReferenceGrid,
                myLanguageController.makeMenu(), help);
        myToolBar.getItems().add(myHbox);
    }

    /**
     * Adds the pane to the BorderPane
     */
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
     * ColorPicker Factory
     * 
     * @param property
     *            String label for ColorPicker
     * @param handler
     *            EventHandler for ColorPicker
     * @return Completed ColorPicker
     */
    private ColorPicker makeColorPicker (String property, EventHandler<ActionEvent> handler) {
        ColorPicker result = new ColorPicker();
        result.setOnAction(handler);
        result.getStyleClass().add("split-button");
        result.setPromptText(property);
        return result;
    }

    /**
     * Sets the background color using a colorpicker
     */
    public void backgroundColor () {
        Color c = myColorPicker.getValue();
        myCommandString.setCommand(
                "SETBACKGROUND " + c.getRed() + " " + c.getGreen() + " " + c.getBlue(),
                Constants.SETTING);

    }

    /**
     * Toggles the visibility of the Grid
     */
    public void toggleGrid () {
        myView.changeGridVisibility();
    }

    /**
     * Allows for the opening of a help page in an Internet Browser
     */
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
