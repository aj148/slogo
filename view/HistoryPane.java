package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class HistoryPane extends Pane implements Observer {

    private List<String> myHistory = new ArrayList<String>();
    private ScrollPane myScrollPane = new ScrollPane();
    private VBox myHistoryDisplay = new VBox();
    private CommandString myCommandString;

    public HistoryPane (CommandString cs) {
        myCommandString = cs;
        myCommandString.addObserver(this);
        myScrollPane.setContent(myHistoryDisplay);
        myScrollPane.setPrefWidth(200);
    }

    public void addHistoryItem (String s) {
        Hyperlink link = new Hyperlink(s);
        myHistory.add(s);
        myHistoryDisplay.getChildren().add(link);
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                myCommandString.setCommand(s);
            }
        });
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setRight(myScrollPane);
        return p;
    }

    @Override
    public void update (java.util.Observable o, Object arg) {
        addHistoryItem(myCommandString.getCommand());
    }

}
