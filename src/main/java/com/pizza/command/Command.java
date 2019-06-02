package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.exception.ApplicationException;

public interface Command {
    void execute(CommandContext context) throws ApplicationException;
}
