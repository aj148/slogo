package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import controller.Controller;
import controller.MasterController;
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
    private List<Pane> myPanes = new ArrayList<Pane>();
    /**
     * CommandString containing the current command to be passed to the backend.
     */
    private CommandString myCommand = new CommandString(this);
    private ViewPane myView = new ViewPane();
    private Controller myController = new Controller(myView);
    private MasterController myMasterController;

    /**
     * Constructor. Adds Panes to myPanes.
     */
    public PaneController () {
        myMasterController = new MasterController("English");
        myPanes.add(myView);
        myPanes.add(new ButtonPane(myCommand));
        myPanes.add(new HistoryPane(myCommand));
        myPanes.add(new InputPane(myCommand));
        myPanes.add(new TurtleControllerPane(myCommand));
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

    public void showError (String s) {
        myCommand.setCommand(s, 2);
    }

    /**
     * When the CommandString changes (a new command has been input), the update method sends the
     * command to be parsed by the backend.
     */
    @Override
    public void update (Observable obs, Object arg1) {
        String s = myCommand.getCommand().toLowerCase();
        myController.getInput(s);
    }

}
