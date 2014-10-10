package view;

import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 * Subclass of Pane that implements a scrollable Vbox which is populated with hyperlinks of commands
 * as they are input. Allows old commands to be clicked on to be resubmitted
 * 
 * @author Team 14
 *
 */
public class HistoryPane extends Pane implements Observer {

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
        if (myCommandString.getType() == 1) {
            Hyperlink link = new Hyperlink(s);
            myHistoryDisplay.getChildren().add(link);
            link.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle (ActionEvent e) {
                    myCommandString.setCommand(s, 1);
                }
            });
        }
        else if (myCommandString.getType() == 2) {
            myHistoryDisplay.getChildren().add(new Label(myCommandString.getCommand()));
        }
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
