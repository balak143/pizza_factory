package com.pizza.command;

import java.util.List;

public class CommandExecutor {

    public void execute(List<Command> commands, Context context) {
        for (Command command:
                commands) {
            boolean executeSuccessful = command.execute(context);
            if(!executeSuccessful) {
                break;
            }
        }
    }
}
