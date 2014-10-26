package commands;

import javafx.scene.paint.Color;
import model.Model;

public class GetPenColorCommand extends ZeroInputCommand {

    @Override
    public double executeCommand (Model model) {
        Color penColor = getFirstTurtle(model).getPenColor();
        return (penColor.getRed() * 255) + (penColor.getGreen() * 255000)
                + (penColor.getBlue() * 255000000);
    }
}