package view.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

/**
 * Contains a Palette of images that can be used to set turtle images
 * 
 * @author Team 14
 *
 */
public class ImagePalette {
    private static final String TURTLE = "/resources/images/LogoTurtle2.png";
    private static final String TRIANGLE = "/resources/images/Triangle.png";
    private static final String CIRCLE = "/resources/images/Circle.png";
    private static final String DUVALL = "/resources/images/RCD.png";
    private Map<Integer, String> myImages = new HashMap<Integer, String>();
    private List<String> myChoices = new ArrayList<String>();
    private ObservableList<String> myObservable = FXCollections.observableList(myChoices);
    private ChoiceBox<String> myChoiceImages = new ChoiceBox<String>(myObservable);
    private String myCurrentImage = TURTLE;
    private int myCurrentImageID;

    /**
     * Default Constructor. Populates with default image options.
     */
    public ImagePalette () {
        myImages.put(0, TURTLE);
        myImages.put(1, TRIANGLE);
        myImages.put(2, CIRCLE);
        myImages.put(3, DUVALL);
        myObservable.add("Turtle");
        myObservable.add("Triangle");
        myObservable.add("Circle");
        myObservable.add("Duvall");
        myChoiceImages.setMaxWidth(100);
        myChoiceImages.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed (ObservableValue ov, Number value, Number new_value) {
                        myCurrentImage = myImages.get(new_value.intValue());
                        myCurrentImageID = new_value.intValue();
                    }
                });

    }

    /**
     * Adds an image to the palette
     * 
     * @param s
     *            String containing the file path to image
     * @param f
     *            String containing the name of the new image
     */
    public void addImage (String s, String f) {
        myImages.put(myImages.size(), s);
        myObservable.add(f);
    }

    /**
     * Gets an image file path from the palette
     * 
     * @param i
     *            int representing ID of image
     * @return String containing file path to image
     */
    public String getImage (int i) {
        return myImages.get(i);
    }

    /**
     * Getter for the current image set
     * 
     * @return String containing file path to image
     */
    public String getCurrentImage () {
        return myCurrentImage;
    }

    /**
     * Getter for the current image ID
     * 
     * @return ID representing current image ID
     */
    public int getCurrentImageID () {
        return myCurrentImageID;
    }

    /**
     * Getter to get the ChoiceBox with the Image options
     * 
     * @return ChoiceBox with the Image options
     */
    public ChoiceBox<String> getBox () {
        return myChoiceImages;
    }
}
