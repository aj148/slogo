package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.BorderPane;


public class PaneController implements Observer {
    List<Pane> myPanes = new ArrayList<Pane>();

    public PaneController () {
        myPanes.add(new ButtonPane());
        myPanes.add(new HistoryPane());
        myPanes.add(new InputPane());
    }

    public BorderPane populate (BorderPane bp) {
        for (Pane p : myPanes) {
            bp = p.addPane(bp);
        }
        return bp;
    }

    @Override
    public void update (java.util.Observable arg0, Object arg1) {
        // TODO Auto-generated method stub

    }
}
