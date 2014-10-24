package view.languages;

import java.util.Map;

public class LanguageProperties {
	private Map<String, String> myLanguages;
	public String Background = "Background";
	public String ToggleGrid;

	public void setLanguage(Map l){
		myLanguages = l;
		Background = myLanguages.get("Background");
		ToggleGrid = myLanguages.get("ToggleGrid");
	}
}
