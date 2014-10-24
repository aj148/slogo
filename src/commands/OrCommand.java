package commands;

public class OrCommand extends TwoInputCommand {

    @Override
    public double executeCommand () {
        return (myParameterOne != 0 || myParameterTwo != 0) ? 0 : 1;
    }
}