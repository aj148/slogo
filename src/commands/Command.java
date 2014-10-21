package commands;

import model.Model;
public abstract class Command {
	
    public abstract int getNumParameters();
    
    public double executeCommand(Model model) {
    	return 0;
    }
    
    public String getClassName(){
		return this.getClass().getName();
    }
}