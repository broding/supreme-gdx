package nl.basroding.supreme.command;

import java.util.LinkedList;

public class CommandExecution {

    private LinkedList<Command> commands;

    public CommandExecution(Command command){
        commands = new LinkedList<>();
        commands.addLast(command);
    }

    public CommandExecution then(Command command){
        commands.addLast(command);
        return this;
    }
}
