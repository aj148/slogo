package commands;

public abstract class Command {
    
    public abstract int getNumParameters();

    public double executeCommand () {
        return 0;
    }
    
    public String getClassName(){
		return this.getClass().getName();
    }
}