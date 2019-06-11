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

public class DeluxeVeggiePizzaModelBuilderTest {
    DeluxeVeggiePizzaModelBuilder deluxeVeggiePizzaModelBuilder = null;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validate_build_for_pizzaIngredients() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = preparePizzaInputDataForDeluxeVeggiePizza();
        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        AbstractPizzaModel pizzaModel = deluxeVeggiePizzaModelBuilder.build(context);

        Assert.assertEquals("Deluxe Veggie", pizzaModel.getName());
        List<IngredientModel> ingredients = pizzaModel.getPizzaIngredientsModel().getIngredients();
        Assert.assertNotNull("Ingredients should not be Null", ingredients);
        Assert.assertEquals("Ingredients Size should be 6 ", 6, ingredients.size());
        List<String> originalList = ingredients.stream().map(IngredientModel::getProductCode).collect(Collectors.toList());

        List<String> expectedList = Arrays.asList(PizzaIngredientsName.SAUCE.getName(), PizzaIngredientsName.CHEESE.getName(),
                PizzaIngredientsName.PEPPERONI.getName(), PizzaIngredientsName.RED_PEPPER.getName(), PizzaIngredientsName.OREGANO.getName(),
                PizzaIngredientsName.GARLIC.getName());

        Assert.assertEquals("Miss match in Pizza Ingredients  ", expectedList, originalList);
    }

    @Test
    public void validate_build_for_toppings() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = preparePizzaInputDataForDeluxeVeggiePizza();
        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        AbstractPizzaModel pizzaModel = deluxeVeggiePizzaModelBuilder.build(context);

        List<AbstractToppingModel> toppings = pizzaModel.getToppings();
        Assert.assertEquals("Toppings size should be 2", 2, toppings.size());

        List<String> originalList = toppings.stream().map(AbstractToppingModel::getIngredientModel).
                map(ingredientModel -> ingredientModel.getProductCode()).collect(Collectors.toList());

        List<String> expectedList = Arrays.asList(ToppingName.CHICKEN_TIKKA.getName(),ToppingName.BLACK_OLIVE.getName());

        Assert.assertEquals("Miss match in Topping Ingredients  ", expectedList, originalList);
    }

    @Test
    public void validate_build_with_required_quantities() throws ApplicationException {
        expected.expect(ApplicationException.class);
        expected.expectMessage("Ingredient is not available for  Product");
        BuildContext context = new BuildContext();
        PizzaInputData pizzaInputData = preparePizzaInputDataForDeluxeVeggiePizza();
        IngredientQtyDeriveService.getInstance().clearQuantities();
        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        deluxeVeggiePizzaModelBuilder.build(context);
        IngredientQtyDeriveService.getInstance().loadRequiredQuantities();
    }
    @Test
    public void validate_getMultiplier_for_size_large() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Large");

        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        double multiplier = deluxeVeggiePizzaModelBuilder.getMultiplier();

        Assert.assertEquals("Multiplier is not 2.168", 2.168, multiplier, 0.000000d);
    }

    @Test
    public void validate_getMultiplier_for_size_medium() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Medium");

        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        double multiplier = deluxeVeggiePizzaModelBuilder.getMultiplier();

        Assert.assertEquals("Multiplier is not 1.338", 1.338, multiplier, 0.000000d);
    }

    @Test
    public void validate_getMultiplier_for_size_regular() throws ApplicationException {
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Regular");
        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        double multiplier = deluxeVeggiePizzaModelBuilder.getMultiplier();
        Assert.assertEquals("Multiplier is not 1", 1, multiplier, 0.000000d);
    }

    @Test
    public void validate_getType() throws ApplicationException {
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Regular");

        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        IngredientType pizzaType = deluxeVeggiePizzaModelBuilder.getPizzaType();

        Assert.assertEquals("Deluxe Veggie pizza type should be VEG", IngredientType.VEG, pizzaType);
    }

    @Test
    public void validate_getIngredientRequiredQty() throws ApplicationException {
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Regular");

        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        //IngredientType pizzaType = pizzaModelBuilder.getIngredientRequiredQty();

        //Assert.assertEquals("Deluxe Veggie pizza type should be VEG" , IngredientType.VEG, pizzaType);
    }

    private PizzaInputData preparePizzaInputDataForDeluxeVeggiePizza() {
        IngredientQtyDeriveService ingredientQtyDeriveService = IngredientQtyDeriveService.getInstance();
        ingredientQtyDeriveService.loadRequiredQuantities();
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setCrustName(CrustName.WHEAT_THIN_CRUST.getName());
        pizzaInputData.setPizzaSize(Size.LARGE.getName());
        pizzaInputData.setName(PizzaName.DELUXE_VEGGIE.getName());
        pizzaInputData.addToppings(ToppingName.CHICKEN_TIKKA.getName());
        pizzaInputData.addToppings(ToppingName.BLACK_OLIVE.getName());
        return pizzaInputData;
    }

}