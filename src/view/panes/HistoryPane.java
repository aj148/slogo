package view.panes;

import java.util.Observer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import view.CommandString;
import view.Constants;

/**
 * Subclass of Pane that implements a scrollable Vbox which is populated with
 * hyperlinks of commands as they are input. Allows old commands to be clicked
 * on to be resubmitted
 *
 * @author Team 14
 *
 */
public class HistoryPane extends PaneModule implements Observer {

    private VBox myRoot = new VBox();
    private ScrollPane myHistoryScroll = new ScrollPane();
    private ScrollPane mySavedScroll = new ScrollPane();
    private VBox myHistoryDisplay = new VBox();
    private VBox mySavedDisplay = new VBox();
    private CommandString myCommandString;

    public HistoryPane (CommandString cs) {
        myCommandString = cs;
        myCommandString.addObserver(this);
        myHistoryScroll.setContent(myHistoryDisplay);
        myHistoryScroll.setPrefWidth(200);
        mySavedScroll.setContent(mySavedDisplay);
        mySavedScroll.setPrefWidth(200);
        myRoot.getChildren().addAll(new Label("Command History"), myHistoryScroll,
                new Label("User-Defined Commands"), mySavedScroll);
    }

    public void addHistoryItem (String s) {
        if (myCommandString.getType() == Constants.COMMAND
                || myCommandString.getType() == Constants.USER_DEFINE) {
            Hyperlink link = new Hyperlink(s);
            if (myCommandString.getType() == Constants.COMMAND) {
                myHistoryDisplay.getChildren().add(link);
            } else {
                mySavedDisplay.getChildren().add(link);
            }
            link.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle (ActionEvent e) {
                    myCommandString.setCommand(s, Constants.COMMAND);
                }
            });
        } else if (myCommandString.getType() == Constants.ERROR) {
            myHistoryDisplay.getChildren().add(new Label(myCommandString.getCommand()));
            if (myHistoryDisplay.getChildren().size() >= 2) {
                myHistoryDisplay.getChildren().remove(myHistoryDisplay.getChildren().size() - 2);
            }
        }
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setRight(myRoot);
        return p;
    }

    @Override
    public void update (java.util.Observable o, Object arg) {
        addHistoryItem(myCommandString.getCommand());
    }

}
