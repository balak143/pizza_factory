import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());
    public static void main(String[] args)throws ApplicationException {

        try {
            ArrayList<String> list = new ArrayList<>();
            list.add("ONE");
            list.add("TWO");
            list.add("THREE");
            list.stream().forEach(s -> {
                try {
                    throw new ApplicationException("Test");
                } catch (ApplicationException e) {
                    ThrowingConsumer.sneakyThrow(e);
                }
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

     /*   Pizza pizza = new PizzaBuilder(VEGETARIAN.DeluxeVeggie)
                .ofSize(Size.MEDIUM)
                .withCrust(new WheatThinCrust())
                .havingToppings(new BlackOlive(),new ChickenTikka())
                .build();
       PizzaOrder pizzaOrder =  new PizzaOrder(pizza, 1)
                .withSides(new ColdDrinkSidesModel(), new MousseCakeSidesModel());
        PizzaOrder pizzaOrder1 =  new PizzaOrder(pizza, 1);

        logger.info(pizzaOrder.toString());
        logger.info(pizzaOrder1.toString());
        //System.out.println(pizzaOrder);
        OrderingService pizzaService = new TerminalOrderingService(pizzaOrder, pizzaOrder1);
        logger.info("Pizza Order Total Cost - "+pizzaService.calculatePrice());
        pizzaService.placeOrder();
        pizzaService.validateOrder();*/
    }

}

