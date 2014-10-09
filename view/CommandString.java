package view;

import java.util.Observable;
import java.util.Observer;

public class CommandString extends Observable{

    private String command;
    
    public CommandString(Observer o){
        addObserver(o);
        command = "";
    }
    
    public void setCommand(String s){
        command = s;
        setChanged();
        notifyObservers();
    }
    
    
}
