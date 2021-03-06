package view.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import view.CommandString;
import view.Constants;
import view.panes.ButtonPaneModule;
import view.panes.HistoryPaneModule;
import view.panes.InputPaneModule;
import view.panes.PaneModule;
import view.panes.TurtleControllerPaneModule;
import view.panes.ViewPaneModule;
import controller.Controller;
import controller.MasterController;

/**
 * Contains all Panes populating the User Interface. Builds the User Interface
 * with the Panes. Provides an interface between the Panes as well as between
 * the Panes and the Model Controller.
 *
 * @author Team 14
 *
 */
public class PaneController implements Observer {
    /**
     * Contains all Panes in the User Interface
     */
    private List<PaneModule> myPanes = new ArrayList<PaneModule>();
    /**
     * CommandString containing the current command to be passed to the backend.
     */
    private CommandString myCommand = new CommandString(this);
    private ImagePalette myImagePalette = new ImagePalette();
    private ViewPaneModule myView = new ViewPaneModule(myImagePalette);
    private Controller myController = new Controller(myView, this);
    private MasterController myMasterController = new MasterController("English");;
    private LanguageController myLanguageController = new LanguageController(myMasterController);

    /**
     * Constructor. Adds Panes to myPanes.
     */
    public PaneController (BorderPane bp, VBox v) {
        myPanes.add(myView);
        myPanes.add(new ButtonPaneModule(myCommand, myLanguageController, myView, v));
        myPanes.add(new HistoryPaneModule(myCommand));
        myPanes.add(new InputPaneModule(myCommand));
        myPanes.add(new TurtleControllerPaneModule(myCommand, myImagePalette, myView));
        populate(bp);
    }

    /**
     * Iterates through all Panes in myPanes and properly adds them to and
     * configures them in the BorderPane to be displayed in the User Interface.
     *
     * @param bp
     *            BorderPane that the Panes are to be added to.
     * @return BorderPane with Panes configured and populated.
     */
    public void populate (BorderPane bp) {
        for (PaneModule p : myPanes) {
            bp = p.addPane(bp);
        }
    }

    /**
     * Shows an error from the backend
     * 
     * @param s
     *            String representing an error
     */
    public void showError (String s) {
        myCommand.setCommand(s, Constants.ERROR);
    }

    /**
     * When the CommandString changes (a new command has been input), the update
     * method sends the command to be parsed by the backend.
     */
    @Override
    public void update (Observable obs, Object arg1) {
        String s = myCommand.getCommand().toLowerCase();
        if ((myCommand.getType() != Constants.USER_DEFINE)
                && (myCommand.getType() != Constants.ERROR)) {
            myController.getInput(s);
        }
    }
}