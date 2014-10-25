package commands;

import model.Model;
import model.Turtle;

public abstract class Command {
	
	protected Command[] myParameters;
	
	public Command(){
		myParameters = new Command[0];
	}
	
	public Command(int numParameters){
		myParameters = new Command[numParameters];
	}
	
    public int getNumParameters(){
    	return myParameters.length;
    }
    
    public void setParameters(Command[] parameters){
    	for(int i = 0; i < myParameters.length; i++){
    		myParameters[i] = parameters[i];
    	}
    }
    
    public Command getParameter(int index){
        return myParameters[index];
    }
    
    public double executeCommand (Model model) {
    	double last = 0;
    	for(Turtle a : model.getManager().getCurrentSet()){
    		last = updateTurtle(model, a);
    	}
        return last;
    }
    
    protected double updateTurtle(Model model, Turtle a) {
		return 0;
	}
    
    protected Turtle getFirstTurtle(Model model){
    	return model.getManager().getCurrentSet().iterator().next();
    }
    
	public String getClassName(){
		return this.getClass().getName();
    }
}