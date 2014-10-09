package view;

import java.util.Observable;
import java.util.Observer;

public class CommandString extends Observable{

    private String myCommand;
    
    public CommandString(Observer o){
        addObserver(o);
        myCommand = "";
    }
    
    public void setCommand(String s){
        myCommand = s;
        setChanged();
        notifyObservers();
    }
    
    public String getCommand(){
        return myCommand;
    }
    
}
