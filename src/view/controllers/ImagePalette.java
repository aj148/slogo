package view.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

public class ImagePalette {
    private static final String TURTLE = "/resources/images/LogoTurtle2.png";
    private static final String TRIANGLE = "/resources/images/Triangle.png";
    private static final String CIRCLE = "/resources/images/Circle.png";
    private static final String DUVALL = "/resources/images/RCD.png";
    private Map<Integer, String> myImages = new HashMap<Integer, String>();
    private List<String> myChoices = new ArrayList<String>();
    private ObservableList<String> myObservable = FXCollections.observableList(myChoices);
    private ChoiceBox myChoiceImages = new ChoiceBox<String>(myObservable);
    private HBox myImageBar = new HBox();

    // private ComboBox myChoices = new ComboBox();

    public ImagePalette () {
        myImages.put(0, TURTLE);
        myImages.put(1, TRIANGLE);
        myImages.put(2, CIRCLE);
        myImages.put(3, DUVALL);
        myChoices.add("Turtle");
        myChoices.add("Triangle");
        myChoices.add("Circle");
        myChoices.add("Duvall");
        Button chooseFileButton = makeButton("Add Image", event -> doChoose());
        myImageBar.getChildren().addAll(myChoiceImages,chooseFileButton);
    }

    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = property;
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

    private void doChoose () {
        final Label labelFile = new Label();
        FileChooser fileChooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "Image Files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        // Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        this.addImage(file.getPath());
    }

    public void addImage (String s) {
        myImages.put(myImages.size() + 1, s);
        myChoices.add("User-Defined");
    }

    public String getImage (int i) {
        return myImages.get(i);
    }

    public HBox getBox () {
        return myImageBar;
    }
}
