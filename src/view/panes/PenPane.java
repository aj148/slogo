package view.panes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.CommandString;
import view.Constants;
import model.Pen;

public class PenPane {
    private VBox myVbox = new VBox();
    private CommandString myCommandString;
    private CheckBox myPenToggle = new CheckBox("Toggle PenUp");
    private ColorPicker myColorPicker;
    private ChoiceBox myPenStyles = new ChoiceBox();
    private TextField myPenWidthTextField = new TextField("Insert double from 0 to 1");
    private TextField myPenDashTextField = new TextField("Insert double from 0 to 1");
    private final static String[] PENSTYLE = new String[] { "Thin", "Thick", "Thicker",
            "Thickest", "Dashed", "Dotted" };
    

    public PenPane (CommandString cs) {
        myCommandString = cs;
        myPenWidthTextField.setPrefColumnCount(8);
        myColorPicker = makeColorPicker("Pen Color", event -> changePenColor());
        myPenStyles = makeMenu();
        Button penWidthButton = makeButton("Pen Width", event -> setPenWidth());
        Button penDashButton = makeButton("Pen Dash", event -> setPenDash());
        myVbox.getChildren().addAll(new Separator(), new Label("PEN COMMANDS"), myPenToggle,
                new HBox(myColorPicker,new Label("Pen Color")),
                new HBox(myPenWidthTextField,penWidthButton),
                new HBox(myPenDashTextField,penDashButton));
        

    }

    public VBox getPenPane () {
        return myVbox;
    }
    
    private void setPenWidth() {
        if (!myPenWidthTextField.getText().equals("")) {
            myCommandString.setCommand("setpensize " + myPenWidthTextField.getText(), Constants.SETTING);
            myPenWidthTextField.clear();
        }
    }
    
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }
    
    private void setPenDash() {
        if (!myPenDashTextField.getText().equals("")) {
            myCommandString.setCommand("SETPENDASH " + myPenDashTextField.getText(), Constants.SETTING);
            myPenDashTextField.clear();
        }
    }

    public void setPenStyle (int i) {
        if (i < 4) {
            myCommandString.setCommand("setpensize " + Integer.toString(i/10), Constants.SETTING);
            System.out.println("pensize = " + Integer.toString(i/10));
        } else {
            // myCommandString.setCommand("SETPENDASH " +
            // Integer.toString(i),Constants.SETTING);
            // Change active turtle's pen set dash
        }

    }

    private ColorPicker makeColorPicker (String property, EventHandler<ActionEvent> handler) {
        ColorPicker result = new ColorPicker();
        result.setOnAction(handler);
        result.getStyleClass().add("split-button");
        result.setPromptText(property);
        return result;
    }

    public ChoiceBox makeMenu () {
        ChoiceBox penStyles = new ChoiceBox(FXCollections.observableArrayList("Thin", "Thick",
                "Thicker", "Dashed", "Dotted"));
        penStyles.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    public void changed (ObservableValue ov, Number value, Number new_value) {
                        setPenStyle(new_value.intValue());
                        System.out.println("pen = " + new_value.intValue());
                    }
                });
        return penStyles;
    }

    public void changePenColor () {
        Color c = myColorPicker.getValue();
        String cur = "SETPENCOLOR " + c.getRed() + " " + c.getGreen() + " " + c.getBlue();
        myCommandString.setCommand(cur, 0);
    }

}
