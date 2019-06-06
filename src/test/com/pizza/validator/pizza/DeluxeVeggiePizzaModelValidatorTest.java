package com.pizza.validator.pizza;

import com.pizza.grid.IngredientDB;
import com.pizza.exception.ApplicationException;
import com.pizza.model.crust.WheatThinCrustModel;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.ChickenTikkaPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.DeluxeVeggiePizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.PepperBarbecueChickenPizzaIngredientsModel;
import com.pizza.model.pizza.nonveg.ChickenTikkaPizzaModel;
import com.pizza.model.pizza.nonveg.PepperBarbecueChickenPizzaModel;
import com.pizza.model.pizza.veg.DeluxeVeggiePizzaModel;
import com.pizza.model.topping.BlackOliveToppingModel;
import com.pizza.model.topping.ChickenTikkaToppingModel;
import com.pizza.model.topping.GrilledChickenToppingModel;
import com.pizza.model.topping.PaneerToppingModel;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.crust.SingleCrustValidator;
import com.pizza.validator.topping.NonVegToppingModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;
import com.pizza.validator.topping.VegToppingModelValidator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DeluxeVeggiePizzaModelValidatorTest {
    AbstractPizzaModelValidator pizzaModelValidator = new DeluxeVeggiePizzaModelValidator();
    AbstractPizzaModel pizzaModel = null;
    CrustModelValidator crustModelValidator = null;
    ToppingModelValidator toppingModelValidator = null;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setup() {

        pizzaModel = new DeluxeVeggiePizzaModel();
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
        pizzaModelValidator.setCrustModelValidator(new SingleCrustValidator());
        pizzaModelValidator.setToppingModelValidator(new VegToppingModelValidator());
        crustModelValidator = pizzaModelValidator.getCrustModelValidator();
        toppingModelValidator = pizzaModelValidator.getToppingModelValidator();

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

    @Test
    public void validate_only_one_nonveg_topping_allowed_on_nonveg_pizza() throws Exception {
        expected.expect(ApplicationException.class);
        expected.expectMessage("You can add only one of the non-veg toppings in non-vegetarian pizza.");
        pizzaModel = new PepperBarbecueChickenPizzaModel();
        pizzaModel.setCrustModel(new WheatThinCrustModel());
        PepperBarbecueChickenPizzaIngredientsModel pizzaIngredientsModel = new PepperBarbecueChickenPizzaIngredientsModel();
        pizzaIngredientsModel.add(IngredientDB.BARBEQUE_CHICKEN.ingredientModel());
        pizzaIngredientsModel.add(IngredientDB.CAPSICUM.ingredientModel());
        pizzaModel.setPizzaIngredientsModel(pizzaIngredientsModel);
        ChickenTikkaToppingModel chickenTikkaToppingModel = new ChickenTikkaToppingModel();
        chickenTikkaToppingModel.setIngredientModel(IngredientDB.CHICKEN_TIKKA.ingredientModel());
        pizzaModel.addTopping(chickenTikkaToppingModel);
        GrilledChickenToppingModel grilledChickenToppingModel = new GrilledChickenToppingModel();
        grilledChickenToppingModel.setIngredientModel(IngredientDB.GRILLED_CHICKEN.ingredientModel());
        pizzaModel.addTopping(grilledChickenToppingModel);
        pizzaModelValidator.setToppingModelValidator(new NonVegToppingModelValidator());
        pizzaModelValidator.validate(pizzaModel);
    }

    @Test
    public void validate_at_least_one_crust_should_be_selected_for_a_pizza() throws Exception {
        expected.expect(ApplicationException.class);
        expected.expectMessage("At least one type of crust must be selected for any pizza.");
        pizzaModel = new PepperBarbecueChickenPizzaModel();
        //pizzaModel.setCrustModel(new WheatThinCrustModel());
        PepperBarbecueChickenPizzaIngredientsModel pizzaIngredientsModel = new PepperBarbecueChickenPizzaIngredientsModel();
        pizzaIngredientsModel.add(IngredientDB.BARBEQUE_CHICKEN.ingredientModel());
        pizzaModel.setPizzaIngredientsModel(pizzaIngredientsModel);
        ChickenTikkaToppingModel chickenTikkaToppingModel = new ChickenTikkaToppingModel();
        chickenTikkaToppingModel.setIngredientModel(IngredientDB.CHICKEN_TIKKA.ingredientModel());
        pizzaModel.addTopping(chickenTikkaToppingModel);
        pizzaModelValidator.validate(pizzaModel);
    }

    @Test
    public void validate_pizza_without_toppings() throws Exception {
        pizzaModel = new PepperBarbecueChickenPizzaModel();
        pizzaModel.setCrustModel(new WheatThinCrustModel());
        PepperBarbecueChickenPizzaIngredientsModel pizzaIngredientsModel = new PepperBarbecueChickenPizzaIngredientsModel();
        pizzaIngredientsModel.add(IngredientDB.BARBEQUE_CHICKEN.ingredientModel());
        pizzaModel.setPizzaIngredientsModel(pizzaIngredientsModel);
        pizzaModelValidator.validate(pizzaModel);
    }

    @Test
    public void validate_toppings_without_ingredient() throws Exception {
        expected.expect(ApplicationException.class);
        expected.expectMessage("Ingredient model not found for - Chicken Tikka");

        pizzaModel = new PepperBarbecueChickenPizzaModel();
        pizzaModel.setCrustModel(new WheatThinCrustModel());
        ChickenTikkaToppingModel chickenTikkaToppingModel = new ChickenTikkaToppingModel();
        pizzaModel.addTopping(chickenTikkaToppingModel);

        pizzaModelValidator.validate(pizzaModel);
    }
}