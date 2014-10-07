package commands;

public abstract class Command {
    
    public Command(){
        
    }
    
    abstract public int getNumParameters();
    
    abstract public void setParameters();
    
    abstract public double executeCommand();
}