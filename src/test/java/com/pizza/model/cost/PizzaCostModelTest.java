package com.pizza.model.cost;

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
import static org.mockito.Mockito.*;

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
        costService = mock(IngredientCostService.class);
        deluxeVeggiePizzaModel = mock(DeluxeVeggiePizzaModel.class);
        crustModel = mock(AbstractCrustModel.class);
        ingredientModel = mock(IngredientModel.class);
        pizzaIngredientsModel = mock(AbstractPizzaIngredientsModel.class);
    }

    private void mockRequired() {
        price = new Price("DUMMY", 1.5, "INR");
        when(costService.cost(any(), any())).thenReturn(price);
        when(deluxeVeggiePizzaModel.getCrustModel()).thenReturn(crustModel);
        ArrayList<IngredientModel> list = new ArrayList<>();
        list.add(new IngredientModel("SAUCE", IngredientType.VEG, 10.5, "GRAM"));
        when(deluxeVeggiePizzaModel.getPizzaIngredientsModel()).thenReturn(pizzaIngredientsModel);
        when(pizzaIngredientsModel.getIngredients()).thenReturn(list);
        when(crustModel.getIngredientModel()).thenReturn(ingredientModel);
    }

    @Test
    public void validate_cost_with_crust_and_ingredients() {
        mockRequired();
        //when(toppingModel.getIngredientModel()).thenReturn()
        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 16.5", Double.valueOf(16.5), prices.get(0).getPrice());
        verify(costService, times(2)).cost(any(), any());
    }

    @Test
    public void validate_cost_with_large_size_having_two_toppings() {
        mockRequired();
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);
        list.add(toppingModel);

        when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);
        when(deluxeVeggiePizzaModel.getSize()).thenReturn(Size.LARGE);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 16.5", Double.valueOf(16.5), prices.get(0).getPrice());
        verify(costService, times(2)).cost(any(), any());
    }

    @Test
    public void validate_cost_with_large_size_having_single_topping() {
        mockRequired();
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);

        when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);
        when(deluxeVeggiePizzaModel.getSize()).thenReturn(Size.LARGE);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 16.5", Double.valueOf(16.5), prices.get(0).getPrice());
        verify(costService, times(2)).cost(any(), any());
    }

    @Test
    public void validate_cost_with_toppings() {
        mockRequired();
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);
        when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 39.75", Double.valueOf(39.75), prices.get(0).getPrice());
        verify(costService, times(3)).cost(any(), any());
    }

    @Test
    public void validate_cost_with_no_price_for_crust() {
        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("Price not found for ");

        mockRequired();
        when(costService.cost(any(), any())).thenReturn(null);
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        toppingModel.setIngredientModel(new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM"));
        list.add(toppingModel);
        when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 39.75", Double.valueOf(39.75), prices.get(0).getPrice());
        verify(costService, times(3)).cost(any(), any());
    }

    @Test
    public void validate_cost_with_no_price_topping() {
        expected.expect(IllegalArgumentException.class);
        expected.expectMessage("Price not found for XYZ");
        mockRequired();
        when(costService.cost(any(), any())).thenReturn(price, price, null);
        ArrayList<AbstractToppingModel> list = new ArrayList<>();
        BlackOliveToppingModel toppingModel = new BlackOliveToppingModel();
        IngredientModel ingredientModel = new IngredientModel("XYZ", IngredientType.VEG, 15.5, "GRAM");
        toppingModel.setIngredientModel(ingredientModel);
        list.add(toppingModel);
        when(deluxeVeggiePizzaModel.getToppings()).thenReturn(list);

        PizzaCostModel pizzaCostModel = new PizzaCostModel();
        pizzaCostModel.setPizzaModel(deluxeVeggiePizzaModel);
        pizzaCostModel.setCostService(costService);
        List<Price> prices = pizzaCostModel.cost(today());
        Assert.assertEquals("List size is not equal to 1", 1, prices.size());
        Assert.assertEquals("total price is not equal to 39.75", Double.valueOf(39.75), prices.get(0).getPrice());
        verify(costService, times(3)).cost(any(), any());
    }


}