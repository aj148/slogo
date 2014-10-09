package view;

import javafx.beans.InvalidationListener;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class InputPane extends Pane {

    private HBox myHBox;
    private ScrollPane myScrollPane;
    private TextField myTextField;
    private String myCurrent;
    private CommandString myCommandString;

    public InputPane (CommandString cs) {
        myCurrent = "";
        myCommandString = cs;
        myHBox = new HBox();
        myScrollPane = new ScrollPane();
        myTextField = new TextField();
        myScrollPane.setContent(myTextField);
        myTextField.setPrefColumnCount(60);
        Button submit = new Button("Submit");
        submit.setOnAction(event -> submit());
        myHBox.getChildren().addAll(myScrollPane, submit);
    }

    private void submit () {
        myCurrent = myTextField.getText();
        myCommandString.setCommand(myCurrent);
        System.out.println(myCurrent);
    }

    @Override
    public BorderPane addPane (BorderPane p) {
        p.setBottom(myHBox);
        return p;
    }

}
