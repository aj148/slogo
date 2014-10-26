package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

public class ListCommand extends ZeroInputCommand {

    private List<Command> myCommandList;

    public ListCommand () {
        myCommandList = new ArrayList<Command>();
    }

    public void addParameter (Command parameter) {
        myCommandList.add(parameter);
    }

    public List<Command> getParameters () {
        return myCommandList;
    }

    @Override
    public double executeCommand (Model model) {
        double finalEx = 0;
        for (Command parameter : myCommandList) {
            finalEx = parameter.executeCommand(model);
        }
        return finalEx;
    }

    @Override
    public int getNumParameters () {
        return myCommandList.size();
    }

    public List<Command> getList () {
        return myCommandList;
    }
}