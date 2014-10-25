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

    // private ComboBox myChoices = new ComboBox();

    public ImagePalette () {
        myImages.put(0, TURTLE);
        myImages.put(1, TRIANGLE);
        myImages.put(2, CIRCLE);
        myImages.put(3, DUVALL);
        myObservable.add("Turtle");
        myObservable.add("Triangle");
        myObservable.add("Circle");
        myObservable.add("Duvall");
        System.out.println(myChoices.size());
 
    }




    public void addImage (String s) {
        myImages.put(myImages.size() + 1, s);
        myObservable.add("User-Defined");
        System.out.println(myChoices.size());
    }

    public String getImage (int i) {
        return myImages.get(i);
    }

    public ChoiceBox<String> getBox () {
        return myChoiceImages;
    }
}
