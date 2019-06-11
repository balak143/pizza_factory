package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.crust.CrustName;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.service.ingredient.IngredientQtyDeriveService;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.ToppingName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheeseCornPizzaModelBuilderTest {
    CheeseCornPizzaModelBuilder pizzaModelBuilder = null;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validate_build_for_pizzaIngredients() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = preparePizzaInputDataForDeluxeVeggiePizza();
        pizzaModelBuilder = new CheeseCornPizzaModelBuilder(pizzaInputData);
        AbstractPizzaModel pizzaModel = pizzaModelBuilder.build(context);

        Assert.assertEquals("Cheese And Corn", pizzaModel.getName());
        List<IngredientModel> ingredients = pizzaModel.getPizzaIngredientsModel().getIngredients();
        Assert.assertNotNull("Ingredients should not be Null", ingredients);
        Assert.assertEquals("Ingredients Size should be 7 ", 7, ingredients.size());
        List<String> originalList = ingredients.stream().map(IngredientModel::getProductCode).collect(Collectors.toList());

        List<String> expectedList = Arrays.asList(PizzaIngredientsName.SAUCE.getName(), PizzaIngredientsName.CHEESE.getName(),
                PizzaIngredientsName.PEPPERONI.getName(), PizzaIngredientsName.RED_PEPPER.getName(), PizzaIngredientsName.OREGANO.getName(),
                PizzaIngredientsName.GARLIC.getName(),PizzaIngredientsName.CORN.getName());

        Assert.assertEquals("Miss match in Pizza Ingredients  ", expectedList, originalList);
    }

    @Test
    public void validate_build_for_toppings() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = preparePizzaInputDataForDeluxeVeggiePizza();
        pizzaModelBuilder = new CheeseCornPizzaModelBuilder(pizzaInputData);
        AbstractPizzaModel pizzaModel = pizzaModelBuilder.build(context);

        List<AbstractToppingModel> toppings = pizzaModel.getToppings();
        Assert.assertEquals("Toppings size should be 2", 2, toppings.size());

        List<String> originalList = toppings.stream().map(AbstractToppingModel::getIngredientModel).
                map(ingredientModel -> ingredientModel.getProductCode()).collect(Collectors.toList());

        List<String> expectedList = Arrays.asList(ToppingName.MUSHROOM.getName(),ToppingName.FRESH_TOMATO.getName());

        Assert.assertEquals("Miss match in Topping Ingredients  ", expectedList, originalList);
    }

    @Test
    public void validate_getMultiplier_for_size_large() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Large");

        pizzaModelBuilder = new CheeseCornPizzaModelBuilder(pizzaInputData);
        double multiplier = pizzaModelBuilder.getMultiplier();

        Assert.assertEquals("Multiplier is not 2.7143", 2.7143, multiplier, 0.000000d);
    }

    @Test
    public void validate_getMultiplier_for_size_medium() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Medium");

        pizzaModelBuilder = new CheeseCornPizzaModelBuilder(pizzaInputData);
        double multiplier = pizzaModelBuilder.getMultiplier();

        Assert.assertEquals("Multiplier is not 2.145", 2.145, multiplier, 0.000000d);
    }

    @Test
    public void validate_getMultiplier_for_size_regular() throws ApplicationException {
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Regular");
        pizzaModelBuilder = new CheeseCornPizzaModelBuilder(pizzaInputData);
        double multiplier = pizzaModelBuilder.getMultiplier();
        Assert.assertEquals("Multiplier is not 1", 1, multiplier, 0.000000d);
    }

    @Test
    public void validate_getType() throws ApplicationException {
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Regular");

        pizzaModelBuilder = new CheeseCornPizzaModelBuilder(pizzaInputData);
        IngredientType pizzaType = pizzaModelBuilder.getPizzaType();

        Assert.assertEquals("Cheese Corn pizza type should be VEG", IngredientType.VEG, pizzaType);
    }

    private PizzaInputData preparePizzaInputDataForDeluxeVeggiePizza() {
        IngredientQtyDeriveService ingredientQtyDeriveService = IngredientQtyDeriveService.getInstance();
        ingredientQtyDeriveService.loadRequiredQuantities();
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setCrustName(CrustName.WHEAT_THIN_CRUST.getName());
        pizzaInputData.setPizzaSize(Size.MEDIUM.getName());
        pizzaInputData.setName(PizzaName.CHEESE_CORN.getName());
        pizzaInputData.addToppings(ToppingName.MUSHROOM.getName());
        pizzaInputData.addToppings(ToppingName.FRESH_TOMATO.getName());
        return pizzaInputData;
    }

}