package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.model.crust.CrustName;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.IngredientQtyDeriveService;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.ColdDrinkSidesModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.ToppingName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ColdDrinkSidesModelBuilderTest {
    ColdDrinkSidesModelBuilder coldDrinkSidesModelBuilder = null;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void set() {
        IngredientQtyDeriveService ingredientQtyDeriveService = IngredientQtyDeriveService.getInstance();
        ingredientQtyDeriveService.loadRequiredQuantities();
    }

    @Test
    public void validate_build_for_cold_drink_sides() throws ApplicationException {
        BuildContext context = new BuildContext();

        coldDrinkSidesModelBuilder = new ColdDrinkSidesModelBuilder("Cold Drink");
        AbstractSidesModel sidesModel = coldDrinkSidesModelBuilder.build(context);

        Assert.assertEquals("Object is instance of ColdDrinkSidesModel", true, sidesModel instanceof ColdDrinkSidesModel);
        Assert.assertEquals("Side should be Cold Drink", "Cold Drink", sidesModel.getName());
        Assert.assertEquals("Ingredient should be Cold Drink", "Cold Drink", sidesModel.getIngredientModel().getProductCode());
    }

}