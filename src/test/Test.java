import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

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

        Map<String, Integer> budget = new HashMap<>();
        budget.put("clothes", 120);
        budget.put("grocery", 150);
        budget.put("transportation", 100);
        budget.put("utility", 130);
        budget.put("rent", 1150);
        budget.put("miscellneous", 90);

        System.out.println("map before sorting: " + budget);

        // let's sort this map by values first
        Map<String, Integer> sorted = budget
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));
        System.out.println("map after sorting by values: " + sorted);

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

