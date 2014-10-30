package parser;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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

public class TestParser {
	
	private Parser myParser;
	
	@SuppressWarnings("static-access")
	private void instantiateClasses(){
		MasterController myMasterController = new MasterController("English");
		myParser = myMasterController.myParser;
	}
	
	@Test
	public void testBasicParsing(){
		instantiateClasses();
		List<Command> parsedCommands = myParser.parseInput(" fd 50 ");
		Command forward = new ForwardCommand();
		Command[] fifty = {new ConstantCommand(50)};
		forward.setParameters(fifty);
		
		Assert.assertEquals(forward.getClass(), parsedCommands.get(0).getClass());
	}
	
	@Test
	public void testListParsing(){
		instantiateClasses();
		List<Command> parsedCommands = myParser.parseInput("[ sum 3 3 difference 3 3 product 3 3 quotient 3 3 ]");
		ListCommand parsedList = (ListCommand)parsedCommands.get(0);
		Command list = new ListCommand();
		Command[] threes = {new ConstantCommand(3), new ConstantCommand(3)};
		Command sum = new SumCommand();
		sum.setParameters(threes);
		Command difference = new DifferenceCommand();
		difference.setParameters(threes);
		Command product = new ProductCommand();
		product.setParameters(threes);
		Command quotient = new QuotientCommand();
		quotient.setParameters(threes);
		
		Assert.assertEquals(list.getClass(), parsedCommands.get(0).getClass());
		Assert.assertEquals(sum.getClass(), parsedList.getParameters().get(0).getClass());
		Assert.assertEquals(difference.getClass(), parsedList.getParameters().get(1).getClass());
		Assert.assertEquals(product.getClass(), parsedList.getParameters().get(2).getClass());
		Assert.assertEquals(quotient.getClass(), parsedList.getParameters().get(3).getClass());
	}
	
	@Test
	public void testVariables(){
		instantiateClasses();
		List<Command> parsedCommands = myParser.parseInput(":var");
		VariableCommand variable = new VariableCommand("var");
		
		Assert.assertEquals(variable.getClass(), parsedCommands.get(0).getClass());
		Assert.assertEquals(variable.getVariableName(), ((VariableCommand)parsedCommands.get(0)).getVariableName());
	}
	
	@Test
	public void testErrors(){
		instantiateClasses();
		List<Command> parsedCommands = myParser.parseInput("supercalifragilisticexpialidocious");
		ErrorCommand error = new ErrorCommand("Error: Invalid Input");
		
		Assert.assertEquals(error.getClass(), parsedCommands.get(0).getClass());
		Assert.assertEquals(error.showError(), ((ErrorCommand)parsedCommands.get(0)).showError());
	}
	
	@Test
	public void testDragon(){
		instantiateClasses();
		List<Command> parsedCommands = myParser.parseInput("repeat 4 [ fd 100 rt 90 fd 100 rt 90 fd 50 rt 90 fd 50 rt 90 fd 100 rt 90 fd 25 rt 90 fd 25 rt 90 fd 50 ]");
		RepeatCommand repeat = new RepeatCommand();
		Command parsedRepeat = parsedCommands.get(0);
		Assert.assertEquals(repeat.getClass(), parsedRepeat.getClass());
		
		ConstantCommand four = new ConstantCommand(4);
		ListCommand list = new ListCommand();
		Assert.assertEquals(four.getClass(), parsedRepeat.getParameter(0).getClass());
		Assert.assertEquals(list.getClass(), parsedRepeat.getParameter(1).getClass());
		
		ListCommand parsedList = (ListCommand)parsedRepeat.getParameter(1);
		List<Command> commands = parsedList.getParameters();
		ForwardCommand forward = new ForwardCommand();
		RightCommand right = new RightCommand();
		for(int i = 0; i < commands.size(); i++){
			if(i % 2 == 0){
				Assert.assertEquals(forward.getClass(), commands.get(i).getClass());
			}
			else{
				Assert.assertEquals(right.getClass(), commands.get(i).getClass());
			}
		}
	}
}