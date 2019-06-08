package com.pizza.model.cost;

import com.pizza.exception.ApplicationException;
import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.BlackOliveToppingModel;
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

public class PizzaCostModelTest {
    IngredientCostService costService = null;
    DeluxeVeggiePizzaModel deluxeVeggiePizzaModel = null;
    AbstractCrustModel crustModel = null;
    IngredientModel ingredientModel = null;
    AbstractPizzaIngredientsModel pizzaIngredientsModel = null;
    AbstractToppingModel toppingModel = null;
    Price price = null;

    private Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setup() {
        costService = Mockito.mock(IngredientCostService.class);
        deluxeVeggiePizzaModel = Mockito.mock(DeluxeVeggiePizzaModel.class);
        crustModel = Mockito.mock(AbstractCrustModel.class);
        ingredientModel = Mockito.mock(IngredientModel.class);
        pizzaIngredientsModel = Mockito.mock(AbstractPizzaIngredientsModel.class);
    }

    private void mockRequired() {
        price = new Price("DUMMY", 1.5, "INR");
        Mockito.when(costService.cost(Mockito.any(), Mockito.any())).thenReturn(price);
        Mockito.when(deluxeVeggiePizzaModel.getCrustModel()).thenReturn(crustModel);
        ArrayList<IngredientModel> list = new ArrayList<>();
        list.add(new IngredientModel("SAUCE", IngredientType.VEG, 10.5, "GRAM"));
        Mockito.when(deluxeVeggiePizzaModel.getPizzaIngredientsModel()).thenReturn(pizzaIngredientsModel);
        Mockito.when(pizzaIngredientsModel.getIngredients()).thenReturn(list);
        Mockito.when(crustModel.getIngredientModel()).thenReturn(ingredientModel);
    }

    @Test
    public void validate_cost_with_crust_and_ingredients() {
        mockRequired();
        //Mockito.when(toppingModel.getIngredientModel()).thenReturn()
        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 16.5", Double.valueOf(16.5), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(2)).cost(Mockito.any(), Mockito.any());
    }

    @Test
    public void validate_cost_with_large_size_having_two_toppings() {
        mockRequired();
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);
        list.add(toppingModel);

        Mockito.when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);
        Mockito.when(deluxeVeggiePizzaModel.getSize()).thenReturn(Size.LARGE);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 16.5", Double.valueOf(16.5), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(2)).cost(Mockito.any(), Mockito.any());
    }

    @Test
    public void validate_cost_with_large_size_having_single_topping() {
        mockRequired();
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);

        Mockito.when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);
        Mockito.when(deluxeVeggiePizzaModel.getSize()).thenReturn(Size.LARGE);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 16.5", Double.valueOf(16.5), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(2)).cost(Mockito.any(), Mockito.any());
    }

    @Test
    public void validate_cost_with_toppings() {
        mockRequired();
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);
        Mockito.when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 39.75", Double.valueOf(39.75), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(3)).cost(Mockito.any(), Mockito.any());
    }

    @Test
    public void validate_cost_with_no_price_for_crust() {
        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("Price not found for ");

        mockRequired();
        Mockito.when(costService.cost(Mockito.any(), Mockito.any())).thenReturn(null);
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);
        Mockito.when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 39.75", Double.valueOf(39.75), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(3)).cost(Mockito.any(), Mockito.any());
    }

    @Test
    public void validate_cost_with_no_price_topping() {
        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("Price not found for XYZ");
        mockRequired();
        Mockito.when(costService.cost(Mockito.any(), Mockito.any())).thenReturn(price, price, null);
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        IngredientModel ingredientModel = new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM");
        toppingModel.setIngredientModel(ingredientModel);
        list.add(toppingModel);
        Mockito.when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 39.75", Double.valueOf(39.75), prices.get(0).getPrice());
        Mockito.verify(costService, Mockito.times(3)).cost(Mockito.any(), Mockito.any());
    }


}