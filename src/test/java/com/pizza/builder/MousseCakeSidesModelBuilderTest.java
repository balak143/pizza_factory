package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.service.ingredient.IngredientQtyDeriveService;
import com.pizza.model.sides.AbstractSidesModel;
import com.pizza.model.sides.MousseCakeSidesModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MousseCakeSidesModelBuilderTest {
    MousseCakeSidesModelBuilder mousseCakeSidesModelBuilder = null;

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

        mousseCakeSidesModelBuilder = new MousseCakeSidesModelBuilder("Mousse Cake");
        AbstractSidesModel sidesModel = mousseCakeSidesModelBuilder.build(context);
        Assert.assertEquals("Object is not instance of MousseCakeSidesModel", true, sidesModel instanceof MousseCakeSidesModel);
        Assert.assertEquals("Side is not a Mousse Cake", "Mousse Cake", sidesModel.getName());
        Assert.assertEquals("Ingredient is not a Mousse Cake", "Mousse Cake", sidesModel.getIngredientModel().getProductCode());
    }

}