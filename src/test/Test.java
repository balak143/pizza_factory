import com.pizza.order.*;
import com.pizza.order.builder.PizzaBuilder;
import com.pizza.order.model.crust.WheatThinCrust;
import com.pizza.order.model.pizza.Pizza;
import com.pizza.order.model.sides.ColdDrink;
import com.pizza.order.model.sides.MousseCake;
import com.pizza.order.model.topping.BlackOlive;
import com.pizza.order.model.topping.ChickenTikka;
import com.pizza.order.service.OrderingService;
import com.pizza.order.service.TerminalOrderingService;

import java.util.logging.Logger;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());
    public static void main(String[] args)throws Exception {

        Pizza pizza = new PizzaBuilder(VEGETARIAN.DeluxeVeggie)
                .ofSize(Size.MEDIUM)
                .withCrust(new WheatThinCrust())
                .havingToppings(new BlackOlive(),new ChickenTikka())
                .build();
       PizzaOrder pizzaOrder =  new PizzaOrder(pizza, 1)
                .withSides(new ColdDrink(), new MousseCake());
        PizzaOrder pizzaOrder1 =  new PizzaOrder(pizza, 1);

        logger.info(pizzaOrder.toString());
        logger.info(pizzaOrder1.toString());
        //System.out.println(pizzaOrder);
        OrderingService pizzaService = new TerminalOrderingService(pizzaOrder, pizzaOrder1);
        logger.info("Pizza Order Total Cost - "+pizzaService.calculatePrice());
        pizzaService.placeOrder();
        pizzaService.validateOrder();
    }

}

