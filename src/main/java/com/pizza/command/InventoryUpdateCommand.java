package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.service.inventory.InventoryService;

public class InventoryUpdateCommand implements Command{
    @Override
    public boolean execute(Context context) {
        return true;
    }
}
