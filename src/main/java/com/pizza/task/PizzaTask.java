package com.pizza.task;

import com.pizza.command.Command;
import com.pizza.command.CommandExecutor;
import com.pizza.command.Context;

import java.util.List;
import java.util.concurrent.Callable;

public abstract class PizzaTask implements Callable {

    private CommandExecutor commandExecutor;

    @Override
    public Object call() throws Exception {
        return execute();
    }

    protected abstract Object execute() throws Exception;

    protected void executeCommands(List<Command> commands, Context context) {
        commandExecutor.execute(commands, context);
    }

    public CommandExecutor getCommandExecutor() {
        return commandExecutor;
    }

    public PizzaTask setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        return this;
    }
}
