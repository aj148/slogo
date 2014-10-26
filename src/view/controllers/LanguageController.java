package view.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import controller.MasterController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class LanguageController {
    public final static String DEFAULT_LANGUAGE = "English";
    private final static String[] LANGUAGE = new String[] { "English", "Chinese", "French",
            "Italian", "Portuguese", "Russian" };
    private MasterController myMasterController;

    public LanguageController (MasterController mc) {
        myMasterController = mc;
    }

    public void setLanguage (String s) {
        myMasterController.constructMasterController(s);
    }

    public ChoiceBox makeMenu () {
        ChoiceBox languages = new ChoiceBox(FXCollections.observableArrayList("English", "中文",
                "Français", "Italiano", "Português", "русский"));
        languages.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    public void changed (ObservableValue ov, Number value, Number new_value) {
                        setLanguage(LANGUAGE[new_value.intValue()]);
                    }
                });
        return languages;
    }

}