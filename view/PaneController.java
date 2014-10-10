package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.BorderPane;


/**
 * Contains all Panes populating the User Interface. Builds the User Interface with the Panes.
 * Provides an interface between the Panes as well as between the Panes and the Model Controller.
 * 
 * @author Team 14
 *
 */
public class PaneController implements Observer {
    /**
     * Contains all Panes in the User Interface
     */
    List<Pane> myPanes = new ArrayList<Pane>();
    /**
     * CommandString containing the current command to be passed to the backend.
     */
    CommandString myCommand = new CommandString(this);

    /**
     * Constructor. Adds Panes to myPanes.
     */
    public PaneController () {
        myPanes.add(new ButtonPane());
        myPanes.add(new HistoryPane(myCommand));
        myPanes.add(new InputPane(myCommand));
    }

    /**
     * Iterates through all Panes in myPanes and properly adds them to and configures them in the
     * BorderPane to be displayed in the User Interface.
     * 
     * @param bp BorderPane that the Panes are to be added to.
     * @return BorderPane with Panes configured and populated.
     */
    public BorderPane populate (BorderPane bp) {
        for (Pane p : myPanes) {
            bp = p.addPane(bp);
        }
        return bp;
    }

    /**
     * When the CommandString changes (a new command has been input), the update method sends the
     * command to be parsed by the backend.
     */
    @Override
    public void update (Observable obs, Object arg1) {
        System.out.println(myCommand.getCommand());
    }

}
