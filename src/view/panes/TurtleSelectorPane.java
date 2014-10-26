package view.panes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import view.CommandString;
import view.Constants;

public class TurtleSelectorPane {
    private Set<Integer> myTurtles = new HashSet<Integer>();
    private Set<CheckBox> myBoxes = new HashSet<CheckBox>();
    private Map<CheckBox, Integer> myIDs = new HashMap<CheckBox, Integer>();
    private Set<Integer> myActiveTurtles = new HashSet<Integer>();
    private CommandString myCommandString;
    private CheckBox myToggle = new CheckBox("Toggle Identification");
    private ScrollPane myTurtleScroll = new ScrollPane();
    private VBox myVBox = new VBox();
    private ViewPaneModule myViewPane;

    public TurtleSelectorPane (CommandString cs, ViewPaneModule vp) {
        myCommandString = cs;
        myViewPane = vp;
        myVBox.getChildren().addAll(new Label("TURTLE SELECTION"), myToggle);
        myToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed (ObservableValue<? extends Boolean> ov, Boolean old_val,
                    Boolean new_val) {
                myViewPane.toggleActive(new_val);
            }
        });
        myTurtleScroll.setContent(myVBox);
        myTurtleScroll.setPrefWidth(50);
    }

    public void newTurtle (int id) {
        if (!myTurtles.contains(id)) {
            myTurtles.add(id);
            CheckBox turt = new CheckBox("ID=" + id);
            turt.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed (ObservableValue<? extends Boolean> ov, Boolean old_val,
                        Boolean new_val) {
                    getActiveTurtles();
                }
            });
            for (CheckBox cb : myBoxes) {
                cb.setSelected(false);
            }

            turt.setSelected(true);
            myBoxes.add(turt);
            myIDs.put(turt, id);
            myVBox.getChildren().add(turt);
        }

    }

    public void getActiveTurtles () {
        myActiveTurtles.clear();
        for (CheckBox cb : myBoxes) {
            if (cb.isSelected()) {
                myActiveTurtles.add(myIDs.get(cb));
            }
            toggleActiveTurtles();
        }

    }

    public void toggleActiveTurtles () {
        String s = "tell [ ";
        for (Integer i : myActiveTurtles) {
            s = s + i + " ";
        }
        s = s + "]";
        myCommandString.setCommand(s, Constants.SETTING);
    }

    public ScrollPane getPane () {
        return myTurtleScroll;
    }
}
