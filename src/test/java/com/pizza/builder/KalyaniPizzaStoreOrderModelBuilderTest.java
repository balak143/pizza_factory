package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.pizza.ingredients.IngredientQtyDeriveService;
import com.pizza.utils.PizzaDateTime;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class KalyaniPizzaStoreOrderModelBuilderTest {

    @Test
    public void build() {
        IngredientQtyDeriveService ingredientQtyDeriveService = IngredientQtyDeriveService.getInstance();
        ingredientQtyDeriveService.loadRequiredQuantities();
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.setOrderDate(today());
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setName("Deluxe Veggie");
        pizzaInputData.setPizzaSize("Regular");
        pizzaInputData.setCrustName("Wheat Thin");
        pizzaInputData.addToppings("Black Olive");
        pizzaInputData.addToppings("Chicken Tikka");
        pizzaOrderInputData.setPizzaInputDatas(pizzaInputData);
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        KalyaniPizzaStoreOrderModelBuilder orderModelBuilder = new KalyaniPizzaStoreOrderModelBuilder();
        orderModelBuilder.build(buildContext);
    }

    private Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }
}