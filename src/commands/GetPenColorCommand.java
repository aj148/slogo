package commands;

import javafx.scene.paint.Color;
import model.Model;


/**
 * This class returns turtle's current color index
 * 
 * @author team14
 *
 */
public class GetPenColorCommand extends ZeroInputCommand {
    
    private static int RED_ADJUSTER = 255;
    private static int GREEN_ADJUSTER = 255000;
    private static int BLUE_ADJUSTER = 255000000;

    @Override
    public double executeCommand (Model model) {
        Color penColor = getFirstTurtle(model).getPenColor();
        return (penColor.getRed() * RED_ADJUSTER) + (penColor.getGreen() * GREEN_ADJUSTER)
               + (penColor.getBlue() * BLUE_ADJUSTER);
    }
}
