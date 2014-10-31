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

/**
 * Allows properties of the Pen for a turtle to be configured graphically
 * through the user interface.
 * 
 * @author Team 14
 *
 */
//This entire file is part of my masterpiece.
//Jesse Ling
public class PenPane {
    private VBox myVbox = new VBox();
    private CommandString myCommandString;
    private CheckBox myPenToggle = new CheckBox("Toggle PenUp");
    private ColorPicker myColorPicker;
    private ChoiceBox<String> myPenStyles = new ChoiceBox<String>();
    private TextField myPenWidthTextField = new TextField("double from 0 to 1");
    private TextField myPenDashTextField = new TextField("double from 0 to 1");
    private final static String[] PENSTYLE = new String[] { "Thin", "Thick", "Thicker", "Thickest",
            "Dashed", "Dotted" };

    public PenPane (CommandString cs) {
        myCommandString = cs;
        myPenWidthTextField.setPrefColumnCount(8);
        myPenDashTextField.setPrefColumnCount(8);
        myColorPicker = new Factory().makeColorPicker("Pen Color", event -> changePenColor());
        myPenStyles = makeMenu();
        Button penWidthButton = new Factory().makeButton("Pen Size", event -> setPenWidth());
        Button penDashButton = new Factory().makeButton("Pen Dash", event -> setPenDash());
        myVbox.getChildren().addAll(new Separator(), new Label("PEN COMMANDS"), myPenToggle,

        new HBox(myColorPicker, new Label("Pen Color")),
                new HBox(myPenWidthTextField, penWidthButton),
                new HBox(myPenDashTextField, penDashButton));

        myPenToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed (ObservableValue<? extends Boolean> ov, Boolean old_val,
                    Boolean new_val) {
                if (new_val) {
                    myCommandString.setCommand("pendown", Constants.SETTING);
                } else {
                    myCommandString.setCommand("penup", Constants.SETTING);
                }
            }
        });

    }

    /**
     * Returns the VBox containing the PenPane
     * 
     * @return VBox containing the PenPane
     */
    public VBox getPenPane () {
        return myVbox;
    }

    /**
     * Sets the width of the Pen
     */
    private void setPenWidth () {
        if (!myPenWidthTextField.getText().equals("")) {
            myCommandString.setCommand("setpensize " + myPenWidthTextField.getText(),
                    Constants.SETTING);
            myPenWidthTextField.clear();
        }
    }

    /**
     * Sets the Dash Style of the Pen
     */
    private void setPenDash () {
        if (!myPenDashTextField.getText().equals("")) {
            myCommandString.setCommand("setpendash " + myPenDashTextField.getText(),
                    Constants.SETTING);

            myPenDashTextField.clear();
        }
    }

    /**
     * Sets the toggle correctly when a new turtle is made
     */
    public void newTurtle () {
        myPenToggle.setSelected(false);
        myPenToggle.setSelected(true);
    }

    /**
     * Sets the style of the pen
     * 
     * @param i
     *            int representing the style of the pen
     */
    public void setPenStyle (int i) {
        if (i < 4) {
            myCommandString.setCommand("setpensize " + Integer.toString(i / 10), Constants.SETTING);
            System.out.println("pensize = " + Integer.toString(i / 10));
        } else {
            // myCommandString.setCommand("SETPENDASH " +
            // Integer.toString(i),Constants.SETTING);
            // Change active turtle's pen set dash
        }

    }

    /**
     * Makes the menu for the types of Pen Styles
     * 
     * @return ChoiceBox containing the types of Pen Styles
     */
    public ChoiceBox makeMenu () {
        ChoiceBox penStyles = new ChoiceBox(FXCollections.observableArrayList("Thin", "Thick",
                "Thicker", "Dashed", "Dotted"));
        penStyles.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed (ObservableValue ov, Number value, Number new_value) {
                        setPenStyle(new_value.intValue());
                        System.out.println("pen = " + new_value.intValue());
                    }
                });
        return penStyles;
    }

    /**
     * Changes the color of the pen using a color picker
     */
    public void changePenColor () {
        Color c = myColorPicker.getValue();
        String cur = "SETPENCOLOR " + c.getRed() + " " + c.getGreen() + " " + c.getBlue();
        myCommandString.setCommand(cur, 0);
    }

}
