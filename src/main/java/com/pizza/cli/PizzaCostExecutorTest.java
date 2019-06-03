package com.pizza.cli;

import com.pizza.command.CommandExecutor;
import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.task.PizzaCostTask;
import com.pizza.task.PizzaTask;

import java.util.Date;

public class PizzaCostExecutorTest {

    public static void main(String[] args) throws Exception {
        //Prepare PizzaOrderInputData
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.setOrderDate(new Date());
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setName("Deluxe Veggie");
        pizzaInputData.setPizzaSize("Large");
        pizzaInputData.setCrustName("Wheat Thin");
        pizzaInputData.addToppings("Black Olive");
        pizzaOrderInputData.setPizzaInputDatas(pizzaInputData);
        //Create Pizza Cost Task
        PizzaTask pizzaCostTask = new PizzaCostTask(pizzaOrderInputData);
        pizzaCostTask.setCommandExecutor(new CommandExecutor());
        pizzaCostTask.call();

    }
}
