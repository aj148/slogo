package commands;

import model.Turtle;

public abstract class Command {
	
    public abstract int getNumParameters();
    
    public double executeCommand(Turtle turtle) {
    	return 0;
    }
    
    public String getClassName(){
		return this.getClass().getName();
    }
}