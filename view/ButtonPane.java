package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;


public class ButtonPane extends Pane {

    private ToolBar myToolBar;

    public ButtonPane () {
        myToolBar = new ToolBar();
        Button btn1 = new Button("Test");
        myToolBar.getItems().add(btn1);
        createPropertiesMenu();
    }

    public void createPropertiesMenu () {
        ComboBox properties = new ComboBox();
        Button btn2 = new Button("Test");
        properties.getItems().addAll(btn2);
        myToolBar.getItems().add(properties);
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setTop(myToolBar);
        return p;
    }

}
