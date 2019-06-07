package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.crust.CrustName;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.IngredientQtyDeriveService;
import com.pizza.model.sides.SidesName;
import com.pizza.model.topping.ToppingName;
import org.junit.Assert;
import org.junit.Test;

public class DeluxeVeggiePizzaModelBuilderTest {
    DeluxeVeggiePizzaModelBuilder deluxeVeggiePizzaModelBuilder = null;

    @Test
    public void validate_Build_For_PizzaIngredients() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = preparePizzaInputDataForDeluxeVeggiePizza();
        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        AbstractPizzaModel pizzaModel = deluxeVeggiePizzaModelBuilder.build(context);

        Assert.assertEquals("Deluxe Veggie", pizzaModel.getName());
    }

    @Test
    public void validate_Build_For_PizzaToppings() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = preparePizzaInputDataForDeluxeVeggiePizza();
        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        AbstractPizzaModel pizzaModel = deluxeVeggiePizzaModelBuilder.build(context);

        Assert.assertEquals(2, pizzaModel.getToppings().size());
    }

    @Test
    public void validate_GetMultiplier_For_Size_Large() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Large");

        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        double multiplier = deluxeVeggiePizzaModelBuilder.getMultiplier();

        Assert.assertEquals("Multiplier is not 2.168" , 2.168, multiplier, 0.000000d);
    }

    @Test
    public void validate_GetMultiplier_For_Size_Medium() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Medium");

        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        double multiplier = deluxeVeggiePizzaModelBuilder.getMultiplier();

        Assert.assertEquals("Multiplier is not 1.338" , 1.338, multiplier, 0.000000d);
    }

    @Test
    public void validate_GetMultiplier_For_Size_Regular() throws ApplicationException {
        BuildContext context = new BuildContext();

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setPizzaSize("Regular");

        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        double multiplier = deluxeVeggiePizzaModelBuilder.getMultiplier();

        Assert.assertEquals("Multiplier is not 1" , 1, multiplier, 0.000000d);
    }

    private PizzaInputData preparePizzaInputDataForDeluxeVeggiePizza() {

        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setCrustName(CrustName.WHEAT_THIN_CRUST.getName());
        pizzaInputData.setPizzaSize(Size.LARGE.getName());
        pizzaInputData.setName(PizzaName.DELUXE_VEGGIE.getName());
        pizzaInputData.addToppings(ToppingName.CHICKEN_TIKKA.getName());
        pizzaInputData.addToppings(ToppingName.BLACK_OLIVE.getName());

        return pizzaInputData;
    }

}