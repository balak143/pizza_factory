package com.pizza;

import com.pizza.command.CommandExecutor;
import com.pizza.grid.*;
import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.pizza.ingredients.IngredientQtyDeriveService;
import com.pizza.task.PizzaCostTask;
import com.pizza.task.PizzaOrderTask;
import com.pizza.task.PizzaTask;
import com.pizza.utils.PizzaDateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PizzaCostExecutorTest {
    @Before
     public void init() {
        // Initial Grid. Ideally the services should be mocked with in memory data
        // as we are anyways loading the dummy data, I have used the same data to validate the cases
        CostMemoryGrid costMemoryGrid = new CostMemoryGrid(new CostDataLoader());
        costMemoryGrid.createDataMap();
        GridManager gridManager = GridManager.getInstance();
        gridManager.registerGrid(costMemoryGrid);
        InventoryMemoryGrid inventoryMemoryGrid = new InventoryMemoryGrid(new InventoryDataLoader());
        inventoryMemoryGrid.createDataMap();
        gridManager.registerGrid(inventoryMemoryGrid);
        IngredientQtyDeriveService ingredientQtyDeriveService = IngredientQtyDeriveService.getInstance();
        ingredientQtyDeriveService.loadRequiredQuantities();

    }
    //@Test
    public void test()throws Exception{
        //Prepare PizzaOrderInputData
        init();
        //DeluxeVeg();
        //paneerTikka();
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.setOrderDate(today());
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setName("Paneer Tikka");
        pizzaInputData.setPizzaSize("Regular");
        pizzaInputData.setCrustName("Wheat Thin");
        pizzaOrderInputData.addSides("Cold Drink");
        pizzaOrderInputData.setPizzaInputDatas(pizzaInputData);
        //Create Pizza Cost Task
        PizzaTask pizzaCostTask = new PizzaOrderTask(pizzaOrderInputData);
        pizzaCostTask.setCommandExecutor(new CommandExecutor());
        System.out.println(pizzaCostTask.call());
    }

    private void paneerTikka() throws Exception {
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

    private void DeluxeVeg() throws Exception {
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

    private Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }
}
