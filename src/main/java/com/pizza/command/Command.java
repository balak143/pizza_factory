package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.exception.ApplicationException;

public interface Command {
    boolean execute(Context context);
}
