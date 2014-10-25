package view.panes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.Turtle;

public class TurtleSelectorPane {
    private Set<Integer> myTurtles = new HashSet<Integer>();
    private Set<CheckBox> myBoxes = new HashSet<CheckBox>();
    private Map<CheckBox, Integer> myIDs = new HashMap<CheckBox, Integer>();
    private Set<Integer> myActiveTurtles = new HashSet<Integer>();
    
    private ScrollPane myTurtleScroll = new ScrollPane();
    private VBox myVBox = new VBox();

    public TurtleSelectorPane () {
        myVBox.getChildren().add(new Label("Turtle Selection"));
        myTurtleScroll.setContent(myVBox);
        myTurtleScroll.setPrefWidth(50);
    }

    public void newTurtle (int id) {
        if (!myTurtles.contains(id)) {
            myTurtles.add(id);
            CheckBox turt = new CheckBox("ID=" + id);
            myBoxes.add(turt);
            myIDs.put(turt, (Integer)id);
            myVBox.getChildren().add(turt);
        }

    }

    public Set<Integer> getActiveTurtles () {
        myActiveTurtles.clear();
        for (CheckBox cb : myBoxes) {
            if (cb.isSelected()) {
                myActiveTurtles.add(myIDs.get(cb));
            }
        }
        return myActiveTurtles;
    }

    public ScrollPane getPane () {
        return myTurtleScroll;
    }
}
