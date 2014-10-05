package view;

import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;


/**
 * Provides the main User Interface presented to the User. Implements various Panes(children of
 * Nodes) which provide additional functionality and behavior. Presents the state of the program to
 * the user and allows input from the user through the Pane implementations.
 * 
 * @author Arihant Jain
 * @author Jesse Ling
 *
 */
public class UserInterface {

    private List<ViewPanel> myViews = new ArrayList<ViewPanel>();

    /**
     * Creates the structure of the User Interface and populates the structure accordingly with
     * Panes.
     * 
     * @param s Stage of the Program
     */
    public void initiate (Stage s) {
        myViews.add(new ViewPanel());
    }
}
