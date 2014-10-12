package commands;

public abstract class Command {
    
	public abstract double executeCommand();
	
    public abstract int getNumParameters();
    
    public String getClassName(){
		return this.getClass().getName();
    }
}