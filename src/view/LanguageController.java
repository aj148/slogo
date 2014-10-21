package view;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class LanguageController {
	private Map<String, String> myCommandMap = new HashMap<String, String>();
	private Properties myProp = new Properties();

	public LanguageController() {
		InputStream in = getClass().getResourceAsStream(
				"/resources/languages/English.properties");
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
			if(myCommandMap.containsKey(s1)){
				translated = translated + myCommandMap.get(s1)+" ";
			}
			else{
				translated = translated + s1 + " ";
			}
		}
		System.out.println(translated);
		return translated;
	}
}
