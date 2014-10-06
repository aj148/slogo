package view;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.BorderPane;


public class PaneController {
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
}
