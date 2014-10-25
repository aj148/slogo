package commands;

import model.Model;
import model.Turtle;

public abstract class Command {
	
    public abstract int getNumParameters();
    
    public double executeCommand (Model model) {
    	double last = 0;
    	for(Turtle a : model.getManager().getCurrentList()){
    		last = updateTurtle(model, a);
    	}
        return last;
    }
    
    protected double updateTurtle(Model model, Turtle a) {
		return 0;
	}
    
    protected Turtle getFirstTurtle(Model model){
    	return model.getManager().getCurrentList().iterator().next();
    }
    
	public String getClassName(){
		return this.getClass().getName();
    }
}