package view;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;


public class ButtonPane extends Pane {

    private ToolBar myToolBar;

    public ButtonPane () {
        myToolBar = new ToolBar();
        Button btn1 = new Button("Test");
        myToolBar.getItems().setAll(btn1);
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setTop(myToolBar);
        return p;
    }

}
