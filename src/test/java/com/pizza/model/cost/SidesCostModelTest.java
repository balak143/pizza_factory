package com.pizza.model.cost;

import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.sides.ColdDrinkSidesModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.service.cost.IngredientCostService;
import com.pizza.utils.PizzaDateTime;
import com.pizza.utils.Price;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SidesCostModelTest {
    IngredientCostService costService = null;
    ColdDrinkSidesModel coldDrinkSidesModel = null;
    IngredientModel ingredientModel = null;
    Price price = null;

    private Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setup() {
        costService = Mockito.mock(IngredientCostService.class);
        coldDrinkSidesModel = Mockito.mock(ColdDrinkSidesModel.class);
        ingredientModel = Mockito.mock(IngredientModel.class);
        price = new Price("DUMMY", 1.5, "INR");
        Mockito.when(costService.cost(Mockito.any(), Mockito.any())).thenReturn(price);
        Mockito.when(coldDrinkSidesModel.getIngredientModel()).thenReturn(ingredientModel);
    }


    @Test
    public void cost_with_price_not_found_from_cost_service() {
        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("Price not found for");
        Mockito.when(costService.cost(Mockito.any(), Mockito.any())).thenReturn(null);
        Mockito.when(coldDrinkSidesModel.getIngredientModel()).thenReturn(ingredientModel);
        SidesCostModel sidesCostModel = new SidesCostModel();
        sidesCostModel.setCostService(costService);
        sidesCostModel.setSidesModel(coldDrinkSidesModel);
        List<Price> prices = sidesCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 0.0", Double.valueOf(0.0), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(0)).cost(Mockito.any(), Mockito.any());

    }

    @Test
    public void cost() {
        Mockito.when(coldDrinkSidesModel.getIngredientModel()).thenReturn(ingredientModel);
        Mockito.when(ingredientModel.getRequiredQty()).thenReturn(1.0);
        Mockito.when(costService.cost(Mockito.any(), Mockito.any())).thenReturn(price);
        SidesCostModel sidesCostModel = new SidesCostModel();
        sidesCostModel.setCostService(costService);
        sidesCostModel.setSidesModel(coldDrinkSidesModel);
        List<Price> prices = sidesCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 1.5", Double.valueOf(1.5), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(1)).cost(Mockito.any(), Mockito.any());

    }
}