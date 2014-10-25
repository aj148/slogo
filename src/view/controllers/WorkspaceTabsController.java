package view.controllers;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WorkspaceTabsController {

    private HBox myHbox = new HBox();
    private TabPane myTabPane = new TabPane();
    private List<PaneController> myWorkspaces = new ArrayList<PaneController>();
    private BorderPane myBorderPane;
    private VBox myVBox = new VBox();

    public WorkspaceTabsController (BorderPane bp) {
        myBorderPane = bp;
        Button addWS = new Button("New Workspace");
        addWS.setOnAction(event -> newTab());
        addWS.setMinHeight(40);
        myHbox.getChildren().addAll(myTabPane, addWS);
        myVBox.getChildren().addAll(myHbox);
        newTab();

        myTabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed (ObservableValue<? extends Tab> ov, Tab t, Tab t1) {
                if (t1 != null) {
                    int i = new Integer(t1.getId());
                    PaneController pc = myWorkspaces.get(i);
                    pc.populate(bp);
                }
            }
        });
    }

    private void newTab () {
        Tab tab = new Tab();
        tab.setText("Workspace");
        PaneController control = new PaneController(myBorderPane, myVBox);
        myWorkspaces.add(control);
        tab.setId("" + (myWorkspaces.size() - 1));
        myTabPane.getTabs().add(tab);
    }

}
