package parser;

import java.util.List;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;
import commands.BackwardCommand;
import commands.Command;
import commands.ConstantCommand;
import commands.DifferenceCommand;
import commands.ErrorCommand;
import commands.ForwardCommand;
import commands.ListCommand;
import commands.ProductCommand;
import commands.QuotientCommand;
import commands.RepeatCommand;
import commands.RightCommand;
import commands.SumCommand;
import commands.VariableCommand;
import controller.MasterController;

public class JUnitTest {
    private Parser myParser;
    
    @SuppressWarnings("static-access")
    private void createParser(){
            MasterController myMasterController = new MasterController("English");
            myParser = myMasterController.myParser;
    }
    
    @Test
    public void testForward(){
            createParser();
            Stack<Command> commandsToExecute = myParser.parseInput("fd 10");
            Command forward = new ForwardCommand();
            Command[] ten = {new ConstantCommand(10)};
            forward.setParameters(ten);
            
            Assert.assertEquals(forward.getClass(), commandsToExecute.pop().getClass());
    }
    
    @Test
    public void testBackward(){
            createParser();
            Stack<Command> commandsToExecute = myParser.parseInput("bk 10");
            Command backward = new BackwardCommand();
            Command[] ten = {new ConstantCommand(10)};
            backward.setParameters(ten);
            
            Assert.assertEquals(backward.getClass(), commandsToExecute.pop().getClass());
    }
    
    
    //testing if the second parameter of repeat command is a ListCommand
    @Test
    public void testListCommand(){
        createParser();
        Stack<Command> commandsToExecute = myParser.parseInput("repeat 180 [ fd 1 rt 2 ]");
        Command listCommand = new ListCommand();
        Assert.assertEquals(listCommand.getClass(), commandsToExecute.pop().getParameter(1).getClass());
    }
    
    @Test
    public void testError(){
        createParser();
        Stack<Command> commandsToExecute = myParser.parseInput("IHopeThisIsAnError 50");
        Command error = new ErrorCommand("invalid input");
        
        Assert.assertEquals(error.getClass(), commandsToExecute.pop().getClass());
    }
    
    @Test
    public void testVariable(){
        createParser();
        Stack<Command> commandsToExecute = myParser.parseInput(":v");
        Command variable = new VariableCommand("v");
        
        Assert.assertEquals(variable.getClass(), commandsToExecute.pop().getClass());
    }
    
}
