package view;

import javafx.beans.Observable;
import javafx.scene.layout.BorderPane;


public abstract class Pane implements Observable {

    public Pane () {

    }

    public abstract BorderPane addPane (BorderPane p);

}
