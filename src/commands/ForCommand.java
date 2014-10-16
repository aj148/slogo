package commands;

import java.util.ArrayList;
import java.util.List;

public class ForCommand extends TwoInputCommand {
	
	
	@Override
    public double executeCommand() {
    	double start=((Command) ((ListCommand) myParameterOne).getList().get(1)).executeCommand();
    	double end=((Command) ((ListCommand) myParameterOne).getList().get(2)).executeCommand();
    	double increment=((Command) ((ListCommand) myParameterOne).getList().get(3)).executeCommand();
    	double toReturn=0;
    	for(double i=start; i<end; i+=increment)
    	{
    		toReturn= ((Command) ((ListCommand) myParameterTwo).getList().get((int) i)).executeCommand();
    	}
    	return toReturn;
    }
	

}