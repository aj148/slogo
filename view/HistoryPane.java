package view;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class HistoryPane extends Pane {

    private List<String> myHistory;
    private ScrollPane myScrollPane;
    private VBox myHistoryDisplay;

    public HistoryPane () {
        myScrollPane = new ScrollPane();
        myHistoryDisplay = new VBox();
        myHistory = new ArrayList<String>();
        myHistoryDisplay.getChildren()
                .add(new Label("Hello. I am an example of a possible text input!"));
        myScrollPane.setContent(myHistoryDisplay);
    }

    public void addHistoryItem (String s) {
        myHistory.add(s);
        myHistoryDisplay.getChildren().add(new Label(s));
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setRight(myScrollPane);
        return p;
    }

}
