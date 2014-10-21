package commands;
import model.Model;


public class ClearScreenCommand extends ZeroInputCommand {
	
	@Override
	public double executeCommand(Model model) {
		return turtle.setXAndY(0.0, 0.0);
		// Need signal to clear screen. 
	}
}