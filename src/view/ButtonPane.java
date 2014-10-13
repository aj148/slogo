package view;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;


public class ButtonPane extends Pane {
    private final ToolBar myToolBar = new ToolBar();
    private ComboBox<Button> myComboBox = new ComboBox();
    private HBox myHbox = new HBox();
    private CommandString myCommandString;
    private String myCurrent;
    private ColorPicker myColorPicker;
    private ColorPicker myColorPicker2;

    public ButtonPane (CommandString cs) {
        myCommandString = cs;
        createPropertiesMenu();
    }

    public void createPropertiesMenu () {
        myColorPicker = makeColorPicker("Background Color", event -> backgroundColor());
        myColorPicker2 = makeColorPicker("Pen Color", event -> changePenColor());
        Button toggleReferenceGrid = makeButton("Toggle Grid", event -> toggleGrid());
        Button help = makeButton("Help", event -> help());
        ChoiceBox languages =
                new ChoiceBox(FXCollections.observableArrayList("English", "中文", "Français",
                                                                "Italiano", "Português", "русский"));
        myHbox.getChildren().addAll(new Label("Background"), myColorPicker, new Label("Pen"),
                                    myColorPicker2, toggleReferenceGrid, languages,
                                    help);
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

    private ToggleButton makeToggleButton (String property, EventHandler<ActionEvent> handler) {
        ToggleButton result = new ToggleButton();
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

    public void toggleGrid () {

    }

    public void changePenColor () {

        String myType = "Pen Color ";
        changeColor(myType);

    }

    public void changeColor (String myType) {
        Color c = myColorPicker.getValue();
        System.out.println("New Color's RGB = " + c.getRed() + " " + c.getGreen() + " " +
                           c.getBlue());
        myCurrent = myType + c.toString();
        myCommandString.setCommand(myCurrent, 0);
        System.out.println(myCurrent);
    }

    public void help () {
        String url =
                "http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php";
        try {
            java.awt.Desktop.getDesktop().browse(new URI(url));
        }
        catch (IOException e) {
            System.out.println("IO Exception When Opening Help Page");
        }
        catch (URISyntaxException e) {
            System.out.println("Help Page URL Formatted Incorrectly");
        }
    }
}
