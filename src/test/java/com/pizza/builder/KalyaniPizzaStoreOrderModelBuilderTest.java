package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.input.PizzaOrderInputData;
import com.pizza.model.order.KalyaniPizzaStoreOrderModel;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.ingredients.IngredientQtyDeriveService;
import com.pizza.utils.PizzaDateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

import static org.junit.Assert.*;

public class KalyaniPizzaStoreOrderModelBuilderTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void setup() {
        IngredientQtyDeriveService ingredientQtyDeriveService = IngredientQtyDeriveService.getInstance();
        ingredientQtyDeriveService.loadRequiredQuantities();
    }

    @Test
    public void build_order_model_with_pizza() {
        PizzaOrderInputData pizzaOrderInputData = preparePizzaOrderInputModel();
        PizzaInputData pizzaInputData = pizzaOrderInputData.getPizzaInputDatas().get(0);
        pizzaInputData.setPizzaSize("Regular");
        pizzaInputData.setCrustName("Wheat Thin");
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        KalyaniPizzaStoreOrderModelBuilder orderModelBuilder = new KalyaniPizzaStoreOrderModelBuilder();
        KalyaniPizzaStoreOrderModel kalyaniPizzaStoreOrderModel = orderModelBuilder.build(buildContext);
        AbstractPizzaModel pizzaModel = kalyaniPizzaStoreOrderModel.getPizzaModels().get(0);
        assertEquals("Pizza name is not Deluxe Veggie", "Deluxe Veggie", pizzaModel.getName());
        assertEquals("Size should be Regular", "Regular", pizzaModel.getSize().getName());
        assertEquals("Crust should be Wheat Thin", "Wheat Thin", pizzaModel.getCrustModel().getName());
    }

    @Test
    public void build_order_model_with_pizza_and_topping() {
        PizzaOrderInputData pizzaOrderInputData = preparePizzaOrderInputModel();
        PizzaInputData pizzaInputData = pizzaOrderInputData.getPizzaInputDatas().get(0);
        pizzaInputData.setPizzaSize("Regular");
        pizzaInputData.setCrustName("Wheat Thin");
        pizzaInputData.addToppings("Black Olive");
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        KalyaniPizzaStoreOrderModelBuilder orderModelBuilder = new KalyaniPizzaStoreOrderModelBuilder();
        KalyaniPizzaStoreOrderModel kalyaniPizzaStoreOrderModel = orderModelBuilder.build(buildContext);
        AbstractPizzaModel pizzaModel = kalyaniPizzaStoreOrderModel.getPizzaModels().get(0);
        assertEquals("Pizza name is not Deluxe Veggie", "Deluxe Veggie", pizzaModel.getName());
        assertEquals("", "Regular", pizzaModel.getSize().getName());
        assertEquals("Crust should be Wheat Thin", "Wheat Thin", pizzaModel.getCrustModel().getName());
        assertEquals("Topping size should be 1", 1, pizzaModel.getToppings().size());
        assertEquals("Topping should be Black Olive", "Black Olive", pizzaModel.getToppings().get(0).getName());
    }

    @Test
    public void build_order_model_with_sides() {
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.addSides("Mousse Cake");
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        KalyaniPizzaStoreOrderModelBuilder orderModelBuilder = new KalyaniPizzaStoreOrderModelBuilder();
        KalyaniPizzaStoreOrderModel kalyaniPizzaStoreOrderModel = orderModelBuilder.build(buildContext);
        assertEquals("No pizza is expected ", 0, kalyaniPizzaStoreOrderModel.getPizzaModels().size());
        assertEquals("only one side should be available ", 1, kalyaniPizzaStoreOrderModel.getSidesModels().size());
        assertEquals("Sides should be Mousse Cake", "Mousse Cake", kalyaniPizzaStoreOrderModel.getSidesModels().get(0).getName());
    }


    @Test
    public void build_validate_crust_type() {
        expected.expect(RuntimeException.class);
        expected.expectMessage("Please provide crust type");
        PizzaOrderInputData pizzaOrderInputData = preparePizzaOrderInputModel();
        pizzaOrderInputData.getPizzaInputDatas().get(0).setPizzaSize("Regular");
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        KalyaniPizzaStoreOrderModelBuilder orderModelBuilder = new KalyaniPizzaStoreOrderModelBuilder();
        KalyaniPizzaStoreOrderModel kalyaniPizzaStoreOrderModel = orderModelBuilder.build(buildContext);
        kalyaniPizzaStoreOrderModel.getPizzaModels().get(0);
    }
    @Test
    public void build_validate_size() {
        expected.expect(RuntimeException.class);
        expected.expectMessage("Please provide Pizza size");
        PizzaOrderInputData pizzaOrderInputData = preparePizzaOrderInputModel();
        BuildContext buildContext = new BuildContext();
        buildContext.setPizzaOrderInputData(pizzaOrderInputData);
        KalyaniPizzaStoreOrderModelBuilder orderModelBuilder = new KalyaniPizzaStoreOrderModelBuilder();
        KalyaniPizzaStoreOrderModel kalyaniPizzaStoreOrderModel = orderModelBuilder.build(buildContext);
    }

    private PizzaOrderInputData preparePizzaOrderInputModel() {
        PizzaOrderInputData pizzaOrderInputData = new PizzaOrderInputData();
        pizzaOrderInputData.setOrderDate(today());
        PizzaInputData pizzaInputData = new PizzaInputData();
        pizzaInputData.setName("Deluxe Veggie");
        pizzaOrderInputData.setPizzaInputDatas(pizzaInputData);
        return pizzaOrderInputData;
    }

    private Date today() {
        return PizzaDateTime.getInstance().convert("20190603");
    }
}