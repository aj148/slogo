package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;

/**
 * @author Arihant Jain
 *This is my Masterpiece.
 * Arihant Jain
 */
public class Factory {
    /**
     * Button Factory
     * 
     * @param property - String label
     * @param handler -  EventHandler when button is pressed
     * @return Completed Button
     */
    public Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

    /**
     * ColorPicker Factory
     * 
     * @param property - String label for ColorPicker
     * @param handler -  EventHandler when color is chosen
     * @return Completed ColorPicker
     */
    public ColorPicker makeColorPicker (String property, EventHandler<ActionEvent> handler) {
        ColorPicker result = new ColorPicker();
        result.setOnAction(handler);
        result.getStyleClass().add("split-button");
        result.setPromptText(property);
        return result;
    }
}
