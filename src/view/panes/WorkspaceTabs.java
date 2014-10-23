package view.panes;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;

public class WorkspaceTabs {

	private HBox myHbox = new HBox();
	private TabPane myTabPane = new TabPane();

	public WorkspaceTabs() {
		newTab();
		Button addWS = new Button("New Workspace");
		addWS.setOnAction(event -> newTab());
		addWS.setMinHeight(40);
		myHbox.getChildren().addAll(myTabPane, addWS);
	}

	private void newTab() {
		Tab tab = new Tab();
		tab.setText("Workspace");
		myTabPane.getTabs().add(tab);
	}

	public HBox getWorkspace() {
		return myHbox;
	}
}
