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
    public void build() throws ApplicationException {
        BuildContext context = new BuildContext();
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setCrustName(CrustName.WHEAT_THIN_CRUST.getName());
        pizzaInputData.setPizzaSize(Size.LARGE.getName());
        pizzaInputData.setName(PizzaName.DELUXE_VEGGIE.getName());
        pizzaInputData.addToppings(ToppingName.CHICKEN_TIKKA.getName());
        pizzaInputData.addToppings(ToppingName.BLACK_OLIVE.getName());
        pizzaOrderInputData.setPizzaInputData(pizzaInputData);
        pizzaOrderInputData.addSides(SidesName.COLD_DRINK.getName());
        context.setPizzaOrderInputData(pizzaOrderInputData);
        deluxeVeggiePizzaModelBuilder = new DeluxeVeggiePizzaModelBuilder(pizzaInputData);
        AbstractPizzaModel pizzaModel = deluxeVeggiePizzaModelBuilder.build(context);
        Assert.assertEquals(2, pizzaModel.getToppings().size());
        Assert.assertEquals(Size.LARGE, pizzaModel.getSize());
        Assert.assertEquals("Deluxe Veggie", pizzaModel.getName());
    }

    @Test
    public void createPizzaModel() {
    }

    @Test
    public void getPizzaType() {
    }
}