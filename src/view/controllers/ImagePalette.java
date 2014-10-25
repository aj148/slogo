package view.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;

public class ImagePalette {
    private static final String TURTLE = "/resources/images/LogoTurtle2.png";
    private static final String TRIANGLE = "/resources/images/Triangle.png";
    private static final String CIRCLE = "/resources/images/Circle.png";
    private static final String DUVALL = "/resources/images/RCD.png";
    private Map<Integer, String> myImages = new HashMap<Integer, String>();
    private List<Image> myChoices = new ArrayList<Image>();
    private ObservableList<Image> myObservable = FXCollections.observableList(myChoices);
    private ChoiceBox myChoiceImages = new ChoiceBox(myObservable);

    public ImagePalette () {
        myImages.put(0, TURTLE);
        myImages.put(1, TRIANGLE);
        myImages.put(2, CIRCLE);
        myImages.put(3, DUVALL);
       
    }

    public void addImage (String s) {
        myImages.put(myImages.size() + 1, s);
    }

    public String getImage (int i) {
        return myImages.get(i);
    }

    public ChoiceBox getBox () {
        return myChoiceImages;
    }
}
