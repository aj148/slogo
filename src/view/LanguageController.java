package view;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class LanguageController {
	private Map<String, String> myCommandMap = new HashMap<String, String>();
	private Properties myProp = new Properties();
	public final static String DEFAULT_LANGUAGE = "English";
	private final static String[] LANGUAGE = new String[] { "English",
			"Chinese", "French", "Italian", "Portuguese", "Russian" };

	public LanguageController() {
		setLanguage(DEFAULT_LANGUAGE);
	}

	public void setLanguage(String s) {
		InputStream in = getClass().getResourceAsStream(
				"/resources/languages/" + s + ".properties");
		commandMapper(in);
	}

	private void commandMapper(InputStream i) {
		try {
			myProp.load(i);
			Set<String> props = myProp.stringPropertyNames();
			for (String s : props) {
				String[] values = myProp.getProperty(s).split(",");
				for (String s1 : values) {
					myCommandMap.put(s1, s);
				}
			}
		} catch (IOException ioe) {

		}
	}

	public String translateCommand(String s) {
		String translated = "";
		String[] parts = s.split(" ");
		for (String s1 : parts) {
			if (myCommandMap.containsKey(s1)) {
				translated = translated + myCommandMap.get(s1) + " ";
			} else {
				translated = translated + s1 + " ";
			}
		}
		System.out.println(translated);
		return translated;
	}

	public ChoiceBox makeMenu() {
		ChoiceBox languages = new ChoiceBox(
				FXCollections.observableArrayList("English", "中文", "Français",
						"Italiano", "Português", "русский"));
		languages.getSelectionModel().selectedIndexProperty()
				.addListener(new ChangeListener<Number>() {
					public void changed(ObservableValue ov, Number value,
							Number new_value) {
						setLanguage(LANGUAGE[new_value.intValue()]);
					}
				});
		return languages;
	}
}
