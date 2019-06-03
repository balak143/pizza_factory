package com.pizza.command;

import java.util.List;

public class CommandExecutor {

    public void execute(List<Command> comands, Context context) {
        for (Command command:
                comands) {
            boolean executeSuccessful = command.execute(context);
            if(!executeSuccessful) {
                break;
            }
        }
    }
}
