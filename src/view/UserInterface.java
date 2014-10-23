package view;

import javafx.stage.Stage;
import java.awt.Dimension;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


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
    public static final Dimension DEFAULT_DIMENSIONS = new Dimension(820, 620);

    private Stage myStage;

    public UserInterface (Stage s) {
        myStage = s;
        initiate(myStage);
    }

    /**
     * Creates the structure of the User Interface and populates the structure accordingly with
     * Panes.
     *
     * @param s Stage of the Program
     */
    public void initiate (Stage s) {
        s.setTitle("SLogo");
        BorderPane root = new BorderPane();
        PaneController pb = new PaneController();
        root = pb.populate(root);
        Scene scene = new Scene(root, DEFAULT_DIMENSIONS.width, DEFAULT_DIMENSIONS.height);
        s.setScene(scene);
        s.show();

    }
}
