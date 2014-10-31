package view;

import java.util.Set;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Turtle;

import org.junit.Assert;
import org.junit.Test;

import view.controllers.PaneController;

public class GUITester {
    public PaneController myPaneController = new PaneController(new BorderPane(), new VBox());

    @Test
    public void testMove () {
        myPaneController.myCommand.setCommand("setheading 0 forward 10", Constants.SETTING);
        Set<Turtle> mySet = myPaneController.myView.getTurtles();
        for (Turtle t : mySet) {
            Assert.assertEquals((t.getNewLocation().getX()) - (t.getPrevLocation().getX()), 10);
        }
    }

    @Test
    public void testRotate () {
        myPaneController.myCommand.setCommand("setheading 0 right 90", Constants.SETTING);
        Set<Turtle> mySet = myPaneController.myView.getTurtles();
        for (Turtle t : mySet) {
            Assert.assertEquals(t.getHeading(), 90);
        }
    }

    @Test
    public void testPenColor () {
        myPaneController.myCommand.setCommand("pencolor #cc6633", Constants.SETTING);
        Set<Turtle> mySet = myPaneController.myView.getTurtles();
        for (Turtle t : mySet) {
            Assert.assertEquals(t.getPenColor(), new Color(""#cc6633"));
        }
    }
}
