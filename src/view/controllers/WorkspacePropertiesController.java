package view.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Allows the saving and loading of the properties within a workspace. Not fully
 * implemented and not used.
 * 
 * @author Team 14
 *
 */
public class WorkspacePropertiesController {
    public WorkspacePropertiesController () {
        makeButton("Save Workspace", event -> saveWorkspace());
    }

    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

    public void saveWorkspace () {
        try {
            Properties properties = new Properties();
            // properties.setProperty("Color",
            // currentWorkspace.getColor().toString());
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(new Stage());
            FileWriter fileOut = new FileWriter(file);
            properties.store(fileOut, "Workspace Properties");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
