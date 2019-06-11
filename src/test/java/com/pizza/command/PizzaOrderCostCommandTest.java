package com.pizza.command;

import com.pizza.builder.BuildContext;
import com.pizza.builder.DominosPizzaStoreOrderModelBuilder;
import com.pizza.grid.*;
import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.crust.CrustName;
import com.pizza.model.order.DominosPizzaStoreOrderModel;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.model.sides.SidesName;
import com.pizza.model.topping.ToppingName;
import com.pizza.service.ingredient.IngredientQtyDeriveService;
import com.pizza.utils.PizzaDateTime;
import com.pizza.utils.Price;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PizzaOrderCostCommandTest {
    Command pizzaOrderCostCommand = new PizzaOrderCostCommand();
    PizzaOrderInputData pizzaOrderInputData = null;

    @Before
    public void setup() {
        pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.setOrderDate(today());
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setName(PizzaName.PANEER_TIKKA.getName());
        pizzaInputData.setPizzaSize(Size.REGULAR.getName());
        pizzaInputData.setCrustName(CrustName.WHEAT_THIN_CRUST.getName());
        pizzaOrderInputData.setPizzaInputDatas(pizzaInputData);

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

    private static Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }

    @Test
    public void execute_pizza_large_cost_three_toppings() {
        Context context = new Context();
        PizzaInputData pizzaInputData = pizzaOrderInputData.getPizzaInputDatas().get(0);
        pizzaInputData.setPizzaSize(Size.LARGE.getName());
        pizzaInputData.addToppings(ToppingName.BLACK_OLIVE.getName());
        pizzaInputData.addToppings(ToppingName.MUSHROOM.getName());
        pizzaInputData.addToppings(ToppingName.FRESH_TOMATO.getName());
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        pizzaOrderCostCommand.execute(context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        assertNotNull(prices);
        assertEquals(1,prices.size());
        assertEquals(Double.valueOf(360),prices.get(0).getPrice());
        assertEquals("INR",prices.get(0).getCurrency());
    }

    @Test
    public void execute_pizza_large_cost_with_one_topping() {
        Context context = new Context();
        PizzaInputData pizzaInputData = pizzaOrderInputData.getPizzaInputDatas().get(0);
        pizzaInputData.setPizzaSize(Size.LARGE.getName());
        pizzaInputData.addToppings(ToppingName.BLACK_OLIVE.getName());
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        pizzaOrderCostCommand.execute(context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        assertNotNull(prices);
        assertEquals(1,prices.size());
        assertEquals(Double.valueOf(340),prices.get(0).getPrice());
        assertEquals("INR",prices.get(0).getCurrency());
    }

    @Test
    public void execute_basic_pizza_cost() {
        Context context = new Context();
        pizzaOrderInputData.getPizzaInputDatas().get(0).setName(PizzaName.CHICKEN_TIKKA.getName());
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        pizzaOrderCostCommand.execute(context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        assertNotNull(prices);
        assertEquals(1,prices.size());
        assertEquals(Double.valueOf(210.0),prices.get(0).getPrice());
        assertEquals("INR",prices.get(0).getCurrency());
    }

    @Test
    public void execute_basic_pizza_cost_with_sides() {
        Context context = new Context();
        pizzaOrderInputData.getPizzaInputDatas().get(0).setName(PizzaName.PEPPER_BARBECUE.getName());
        pizzaOrderInputData.addSides(SidesName.COLD_DRINK.getName());
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        pizzaOrderCostCommand.execute(context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        assertNotNull(prices);
        assertEquals(2,prices.size());
        assertEquals(Double.valueOf(220),prices.get(0).getPrice());
        assertEquals("INR",prices.get(0).getCurrency());
        assertEquals(Double.valueOf(55),prices.get(1).getPrice());
        assertEquals("INR",prices.get(1).getCurrency());

    }

    @Test
    public void execute_cost_with_sides_alone() {
        Context context = new Context();
        pizzaOrderInputData.getPizzaInputDatas().clear();
        pizzaOrderInputData.addSides(SidesName.COLD_DRINK.getName());
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        pizzaOrderCostCommand.execute(context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        assertNotNull(prices);
        assertEquals(1,prices.size());
        assertEquals(Double.valueOf(55),prices.get(0).getPrice());
        assertEquals("INR",prices.get(0).getCurrency());
    }


    @Test
    public void execute_cheese_corn_pizza_cost_with_sides() {
        Context context = new Context();
        pizzaOrderInputData.getPizzaInputDatas().get(0).setName(PizzaName.CHEESE_CORN.getName());
        pizzaOrderInputData.addSides(SidesName.MOUSSE_CAKE.getName());
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        pizzaOrderCostCommand.execute(context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        assertNotNull(prices);
        assertEquals(2,prices.size());
        assertEquals(Double.valueOf(175),prices.get(0).getPrice());
        assertEquals("INR",prices.get(0).getCurrency());
        assertEquals(Double.valueOf(90),prices.get(1).getPrice());
        assertEquals("INR",prices.get(1).getCurrency());

    }

    @Test
    public void execute_nonveg_supreme_pizza_cost_with_sides() {
        Context context = new Context();
        pizzaOrderInputData.getPizzaInputDatas().get(0).setName(PizzaName.NONVEG_SUPREME.getName());
        pizzaOrderInputData.addSides(SidesName.COLD_DRINK.getName());
        context.setData("PIZZA_ORDER_INPUT", pizzaOrderInputData);
        DominosPizzaStoreOrderModelBuilder orderModelBuilder = new DominosPizzaStoreOrderModelBuilder();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        DominosPizzaStoreOrderModel pizzaOrderModel = orderModelBuilder.build(buildContext);
        context.setData("PIZZA_ORDER_MODEL", pizzaOrderModel);
        pizzaOrderCostCommand.execute(context);
        List<Price> prices = (List<Price>) context.getData("ORDER_PRICE");
        assertNotNull(prices);
        assertEquals(2,prices.size());
        assertEquals(Double.valueOf(190),prices.get(0).getPrice());
        assertEquals("INR",prices.get(0).getCurrency());
        assertEquals(Double.valueOf(55),prices.get(1).getPrice());
        assertEquals("INR",prices.get(1).getCurrency());

    }
}