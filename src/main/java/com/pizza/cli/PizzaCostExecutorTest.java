package com.pizza.cli;

import com.pizza.command.CommandExecutor;
import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.task.PizzaCostTask;
import com.pizza.task.PizzaTask;
import com.pizza.utils.PizzaDateTime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class PizzaCostExecutorTest {

    public static void main(String[] args) throws Exception {
        //Prepare PizzaOrderInputData
        //DeluxeVeg();
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.setOrderDate(today());
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setName("Paneer Tikka");
        pizzaInputData.setPizzaSize("Regular");
        pizzaInputData.setCrustName("Wheat Thin");
        pizzaInputData.addToppings("Black Olive");
        pizzaOrderInputData.setPizzaInputDatas(pizzaInputData);

        //Create Pizza Cost Task
        PizzaTask pizzaCostTask = new PizzaCostTask(pizzaOrderInputData);

        pizzaCostTask.setCommandExecutor(new CommandExecutor());

        pizzaCostTask.call();


    }

    private static void DeluxeVeg() throws Exception {
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.setOrderDate(today());
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setName("Deluxe Veggie");
        pizzaInputData.setPizzaSize("Regular");
        pizzaInputData.setCrustName("Wheat Thin");
        pizzaInputData.addToppings("Black Olive");
        pizzaInputData.addToppings("Chicken Tikka");
        pizzaOrderInputData.setPizzaInputDatas(pizzaInputData);

        //Create Pizza Cost Task
        PizzaTask pizzaCostTask = new PizzaCostTask(pizzaOrderInputData);

        pizzaCostTask.setCommandExecutor(new CommandExecutor());

        pizzaCostTask.call();
    }

    private static Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }
}
