package commands;

public abstract class ZeroInputCommand extends Command {
    
    @Override
    public int getNumParameters(){
        return 0;
    }
}