package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.service.ingredient.IngredientQtyDeriveService;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.ColdDrinkSidesModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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