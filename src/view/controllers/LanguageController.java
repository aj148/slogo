package view.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import controller.MasterController;

/**
 * Allows selection of various command language translations
 * 
 * @author Team 14
 *
 */
public class LanguageController {
    public static final String DEFAULT_LANGUAGE = "English";
    private static final String[] LANGUAGE = new String[] { "English", "Chinese", "French",
            "Italian", "Portuguese", "Russian" };
    private MasterController myMasterController;

    /**
     * Default Constructor
     * 
     * @param mc
     *            MasterController for the program
     */
    public LanguageController (MasterController mc) {
        myMasterController = mc;
    }

    /**
     * Set the language of the Master Controller
     * 
     * @param s
     *            String representing the language for translation
     */
    public void setLanguage (String s) {
        myMasterController.constructMasterController(s);
    }

    /**
     * Makes a ChoiceBox of the possible language options
     * 
     * @return ChoiceBox of the possible language options
     */
    public ChoiceBox<String> makeMenu () {
        ChoiceBox<String> languages = new ChoiceBox<String>(FXCollections.observableArrayList("English", "中文",
                "Français", "Italiano", "Português", "русский"));
        languages.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed (ObservableValue ov, Number value, Number new_value) {
                        setLanguage(LANGUAGE[new_value.intValue()]);
                    }
                });
        return languages;
    }

}