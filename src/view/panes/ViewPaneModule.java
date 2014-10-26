package view.panes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.Model;
import model.Turtle;
import view.Constants;
import view.TurtleDraw;
import view.controllers.ImagePalette;

/**
 * Responsible for drawing the graphical representation of the turtles movement
 * as its state changes using Observable. Calls on the Draw class to update the
 * graphical representation stored in View when the status of a turtle changes.
 *
 * @author Team 14
 *
 */
public class ViewPaneModule extends PaneModule {

    public boolean gridVisible = true;
    private Color myBackColor;
    private String RGB;
    private Pane myPane = new Pane();
    private TurtleDraw myDraw;
    private Point2D myCurrentPoint = new Point2D(0, 0);
    private List<Line> myGrid = new ArrayList<Line>();
    private Color defColor = Color.LIGHTGRAY;
    private Set<Turtle> myTurtles;
    private ImagePalette myImagePalette;
    private Map<Integer, ImageView> myIcons = new HashMap<Integer, ImageView>();
    private boolean mySelectorCheck = false;
    private Set<Turtle> myActiveTurtles;
    private Model myModel;
    private List<ImageView> myStamps = new ArrayList<ImageView>();

    /**
     * Constructor method called from UserInterface.java
     */
    public ViewPaneModule (ImagePalette ip) {
        myImagePalette = ip;
        myDraw = new TurtleDraw(myImagePalette);
        myBackColor = Constants.DEFAULT_BGCOLOR;
        RGB = toRGB(myBackColor);
        updateBGColor(RGB);
        myPane.setPrefSize(Constants.VIEW_DEFAULT_DIMENSION, Constants.VIEW_DEFAULT_DIMENSION);
        createGrid(defColor);
    }

    public void updateView (Model m) {
        myModel = m;
        myBackColor = m.getBackgroundColor();
        updateBGColor(toRGB(myBackColor));
        myActiveTurtles = m.getTurtleManager().getActiveTurtles();
        myTurtles = m.getTurtleManager().getAllTurtles();
        if ((int) m.getStamp() == 1) {
            makeStamps();
            m.setStamp(0.0);
        }
        if ((int) m.getStamp() == -1) {
            eraseStamps();
            m.setStamp(0.0);
        }
        myTurtles.forEach(turtle -> updateTurtle(turtle));
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setCenter(myPane);
        return p;
    }

    public void showError (String displayMessage) {
        System.out.println(displayMessage);
    }

    private void createGrid (Color c) {
        int loc = 0;
        int cellSize = 10;
        while (loc < Constants.VIEW_DEFAULT_DIMENSION - 10) {
            Line horizontal = new Line(0, loc, Constants.VIEW_DEFAULT_DIMENSION - 10, loc);
            myGrid.add(horizontal);
            Line vertical = new Line(loc, 0, loc, Constants.VIEW_DEFAULT_DIMENSION);
            myGrid.add(vertical);
            loc += cellSize;
        }
        for (Line l : myGrid) {
            l.setStroke(c);
            l.toBack();
            myPane.getChildren().add(l);
        }
    }

    public void changeGridVisibility () {
        for (Line l : myGrid) {
            l.setVisible(!gridVisible);
            l.toBack();
        }
        gridVisible = !gridVisible;
    }

    private void makeStamps () {
        for (Turtle t : myActiveTurtles) {
            ImageView stamp = myDraw.drawTurtle(t, false);
            myStamps.add(stamp);
            myDraw.showTurtle(myPane, stamp);
            myDraw.moveTurtle(stamp, t.getPrevLocation());
            myDraw.setAngle(stamp, t.getHeading());
        }
    }

    private void eraseStamps () {
        for (ImageView s : myStamps) {
            myDraw.hideTurtle(myPane, s);
        }
        myStamps.clear();
    }

    private void updateTurtle (Turtle t) {
        int id = (int) t.getID();
        // wrapping(t);
        if (!myIcons.containsKey(id)) {
            myIcons.put(id, myDraw.drawTurtle(t, myActiveTurtles.contains(t) && mySelectorCheck));
            myDraw.showTurtle(myPane, myIcons.get(id));
        } else {
            myDraw.hideTurtle(myPane, myIcons.get(id));
            myIcons.put(id, myDraw.drawTurtle(t, myActiveTurtles.contains(t) && mySelectorCheck));
            myDraw.showTurtle(myPane, myIcons.get(id));
        }
        if (((int) t.getPenStatus()) == 1) {
            myDraw.drawLine(t.getPrevLocation(), t.getNewLocation());
            myDraw.myPath.setStrokeDashOffset(t.getPenDash());
            myDraw.myPath.setStroke(t.getPenColor());
            myPane.getChildren().add(myDraw.myPath);
        }
        myDraw.setAngle(myIcons.get(id), t.getHeading());
        myDraw.moveTurtle(myIcons.get(id), t.getNewLocation());
    }

    private void wrapping (Turtle t) {
        if (Math.abs(t.getNewLocation().getX()) > Constants.VIEW_DEFAULT_DIMENSION / 2
                || Math.abs(t.getNewLocation().getY()) > Constants.VIEW_DEFAULT_DIMENSION / 2) {
            double x = t.getNewLocation().getX();
            double y = t.getNewLocation().getY();
            if ((Math.abs(t.getNewLocation().getX()) > Constants.VIEW_DEFAULT_DIMENSION / 2)) {
                x = Constants.VIEW_DEFAULT_DIMENSION / 2;
            }
            if ((Math.abs(t.getNewLocation().getY()) > Constants.VIEW_DEFAULT_DIMENSION / 2)) {
                y = Constants.VIEW_DEFAULT_DIMENSION / 2;
            }
            double cur = t.getPenStatus();
            t.setPenStatus(0.0);
            t.setXAndY(x, y);
            t.setPenStatus(cur);
        }
    }

    private void DisplayStats (Turtle t) {
        // t.get
    }

    private void updateBGColor (String RGB) {
        myPane.setStyle("-fx-background-color: rgb( " + RGB + ");");
    }

    private String toRGB (Color c) {
        double r = 255 * c.getRed();
        double g = 255 * c.getGreen();
        double b = 255 * c.getBlue();
        String R = "" + (int) r;
        String G = "" + (int) g;
        String B = "" + (int) b;
        return R + "," + G + "," + B;

    }

    public Set<Turtle> getTurtles () {
        return myTurtles;
    }

    public void toggleActive (boolean b) {
        mySelectorCheck = b;
        updateView(myModel);
    }
}
