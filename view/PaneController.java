package view;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.BorderPane;


public class PaneController implements Observable{
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
    public void addListener (InvalidationListener arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeListener (InvalidationListener arg0) {
        // TODO Auto-generated method stub
        
    }
}
