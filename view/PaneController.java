package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.BorderPane;


public class PaneController implements Observer {
    List<Pane> myPanes = new ArrayList<Pane>();
    CommandString myCommand = new CommandString(this);

    public PaneController () {
        myPanes.add(new ButtonPane());
        myPanes.add(new HistoryPane());
        myPanes.add(new InputPane(myCommand));
    }

    public BorderPane populate (BorderPane bp) {
        for (Pane p : myPanes) {
            bp = p.addPane(bp);
        }
        return bp;
    }

    @Override
    public void update (Observable obs, Object arg1) {
        System.out.println(myCommand.getCommand());
    }

}
