package parser;

import static org.junit.Assert.assertEquals; 

import java.util.Collection;

import org.junit.Test;

import commands.Command;
import commands.ForwardCommand;
import commands.HomeCommand;

public class ParserTest {
    
    @Test
    public void testParser(){
        
//        Parser testParse = new Parser();
//        Collection<Command> commandsToExecute = testParse.parseInput("fd 27 23");
//        assertEquals(commandsToExecute.remove(new ErrorCommand("Error: Invalid input.")), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//        
//        commandsToExecute = testParse.parseInput("fd");
//        assertEquals(commandsToExecute.remove(new ErrorCommand("Error: Invalid input.")), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//        
//        commandsToExecute = testParse.parseInput("+ 3 7 1");
//        assertEquals(commandsToExecute.remove(new ErrorCommand("Error: Invalid input.")), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//        
//        commandsToExecute = testParse.parseInput("+ + + +");
//        assertEquals(commandsToExecute.remove(new ErrorCommand("Error: Invalid input.")), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//        
//        commandsToExecute = testParse.parseInput("xyftkjplp");
//        assertEquals(commandsToExecute.remove(new ErrorCommand("Error: Invalid input.")), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//        
//        commandsToExecute = testParse.parseInput("fd sum 67 21 ]");
//        assertEquals(commandsToExecute.remove(new ErrorCommand("Error: Invalid input.")), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//
//        commandsToExecute = testParse.parseInput("fd 50");
//        assertEquals(commandsToExecute.remove(new ForwardCommand()), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//        
//        commandsToExecute = testParse.parseInput("fd sum 12 12");
//        assertEquals(commandsToExecute.remove(new ForwardCommand()), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
//        
//        commandsToExecute = testParse.parseInput("ifelse less 17 sum 12 6 fd 77 home\nfd 75");
//        assertEquals(commandsToExecute.remove(new HomeCommand()), true);
//        assertEquals(commandsToExecute.remove(new ForwardCommand()), true);
//        assertEquals(commandsToExecute.isEmpty(), true);
    }
}