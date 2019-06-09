package com.pizza.model.cost;

import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.order.PizzaOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.ColdDrinkSidesModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.service.cost.CostService;
import com.pizza.service.cost.IngredientCostService;
import com.pizza.utils.PizzaDateTime;
import com.pizza.utils.Price;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaOrderCostModelTest {

    IngredientCostService costService = null;
    DeluxeVeggiePizzaModel deluxeVeggiePizzaModel = null;
    AbstractCrustModel crustModel = null;
    IngredientModel ingredientModel = null;
    AbstractPizzaIngredientsModel pizzaIngredientsModel = null;
    AbstractToppingModel toppingModel = null;
    Price price = null;
    PizzaOrderModel pizzaOrderModel = null;
    PizzaCostModel pizzaCostModel = null;
    SidesCostModel sidesCostModel = null;
    private Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setup() {
        costService = mock(IngredientCostService.class);
        deluxeVeggiePizzaModel = mock(DeluxeVeggiePizzaModel.class);
        crustModel = mock(AbstractCrustModel.class);
        ingredientModel = mock(IngredientModel.class);
        pizzaIngredientsModel = mock(AbstractPizzaIngredientsModel.class);
        pizzaOrderModel = mock(PizzaOrderModel.class);
        pizzaCostModel = mock(PizzaCostModel.class);
        sidesCostModel = mock(SidesCostModel.class);

    }

    @Test
    public void cost_with_pizza_alone() {
        PizzaOrderCostModel pizzaOrderCostModel = new PizzaOrderCostModel(pizzaOrderModel);
        pizzaOrderCostModel.setCostService(costService);
        pizzaOrderCostModel.setPizzaCostModel(pizzaCostModel);
        List<Price> prices = new ArrayList<>();
        price = new Price("DUMMY", 1.5, "INR");
        prices.add(price);
        when(pizzaCostModel.cost(any())).thenReturn(prices);
        List<AbstractPizzaModel> abstractPizzaModelList = new ArrayList();
        abstractPizzaModelList.add(new DeluxeVeggiePizzaModel());
        when(pizzaOrderModel.getPizzaModels()).thenReturn(abstractPizzaModelList);
        List<Price> priceList = pizzaOrderCostModel.cost(today());
        Assert.assertEquals(1,priceList.size());
        Assert.assertEquals(Double.valueOf(1.5),priceList.get(0).getPrice());
        Assert.assertEquals("DUMMY",priceList.get(0).getName());
        Assert.assertEquals("INR",priceList.get(0).getCurrency());
    }

    @Test
    public void cost_with_sides_alone() {
        PizzaOrderCostModel pizzaOrderCostModel = new PizzaOrderCostModel(pizzaOrderModel);
        pizzaOrderCostModel.setCostService(costService);
        pizzaOrderCostModel.setSidesCostModel(sidesCostModel);
        List<Price> prices = new ArrayList<>();
        price = new Price("DUMMY", 2.5, "INR");
        prices.add(price);
        when(sidesCostModel.cost(any())).thenReturn(prices);
        List<AbstractSidesModel> sidesModels = new ArrayList();
        sidesModels.add(new ColdDrinkSidesModel());
        when(pizzaOrderModel.getSidesModels()).thenReturn(sidesModels);
        List<Price> priceList = pizzaOrderCostModel.cost(today());
        Assert.assertEquals(1,priceList.size());
        Assert.assertEquals(Double.valueOf(2.5),priceList.get(0).getPrice());
        Assert.assertEquals("DUMMY",priceList.get(0).getName());
        Assert.assertEquals("INR",priceList.get(0).getCurrency());
    }
}