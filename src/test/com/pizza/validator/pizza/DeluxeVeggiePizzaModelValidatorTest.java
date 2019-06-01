package com.pizza.validator.pizza;

import com.pizza.cache.IngredientDB;
import com.pizza.exception.ApplicationException;
import com.pizza.model.crust.WheatThinCrustModel;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.ChickenTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.nonveg.ChickenTikkaPizzaModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.topping.BlackOliveToppingModel;
import com.pizza.model.topping.ChickenTikkaToppingModel;
import com.pizza.model.topping.PaneerToppingModel;
import com.pizza.validator.crust.SingleCrustValidator;
import com.pizza.validator.topping.VegToppingModelValidator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DeluxeVeggiePizzaModelValidatorTest {
    AbstractPizzaModelValidator pizzaModelValidator = new DeluxeVeggiePizzaModelValidator();
    AbstractPizzaModel pizzaModel = new DeluxeVeggiePizzaModel();

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setup() {
        pizzaModelValidator.setCrustModelValidator(new SingleCrustValidator());
        pizzaModelValidator.setToppingModelValidator(new VegToppingModelValidator());
        pizzaModel.setCrustModel(new WheatThinCrustModel());
        DeluxeVeggiePizzaIngredientsModel pizzaIngredientsModel = new DeluxeVeggiePizzaIngredientsModel();
        pizzaIngredientsModel.add(IngredientDB.EXTRA_CHEESE.ingredientModel());
        pizzaModel.setPizzaIngredientsModel(pizzaIngredientsModel);
        BlackOliveToppingModel blackOliveToppingModel = new BlackOliveToppingModel();
        blackOliveToppingModel.setIngredientModel(IngredientDB.BLACK_OLIVE.ingredientModel());
        pizzaModel.addTopping(blackOliveToppingModel);
        pizzaModel.addTopping(blackOliveToppingModel);

    }

    @Test
    public void validate_vegpizza_has_vegtappings() throws Exception {
        pizzaModelValidator.validate(pizzaModel);

    }

    @Test
    public void validate_veg_pizza_has_nonveg_tappings() throws Exception {
        expected.expect(ApplicationException.class);
        expected.expectMessage("Vegetarian Pizza - Deluxe Veggie cannot have a non-vegetarian topping - Chicken Tikka");
        ChickenTikkaToppingModel chickenToppingModel = new ChickenTikkaToppingModel();
        chickenToppingModel.setIngredientModel(IngredientDB.CHICKEN_TIKKA.ingredientModel());
        pizzaModel.addTopping(chickenToppingModel);
        pizzaModelValidator.validate(pizzaModel);
    }


    @Test
    public void validate_nonveg_pizza_cannot_have_paneer_tappings() throws Exception {
        expected.expect(ApplicationException.class);
        expected.expectMessage("Non-vegetarian Pizza - Chicken Tikka  cannot have Paneer Topping");
        ChickenTikkaPizzaModel pizzaModel = new ChickenTikkaPizzaModel();
        ChickenTikkaPizzaIngredientsModel pizzaIngredientsModel = new ChickenTikkaPizzaIngredientsModel();
        pizzaIngredientsModel.add(IngredientDB.EXTRA_CHEESE.ingredientModel());
        pizzaModel.setPizzaIngredientsModel(pizzaIngredientsModel);
        pizzaModel.setCrustModel(new WheatThinCrustModel());

        PaneerToppingModel paneerToppingModel = new PaneerToppingModel();
        paneerToppingModel.setIngredientModel(IngredientDB.PANEER.ingredientModel());
        pizzaModel.addTopping(paneerToppingModel);
        pizzaModelValidator.validate(pizzaModel);
    }
}