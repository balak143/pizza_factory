package com.pizza.model.pizza;

import com.pizza.dao.CostData;
import com.pizza.model.enums.Size;
import com.pizza.model.topping.ToppingModel;
import com.pizza.model.crust.Crust;
import com.pizza.model.crust.WheatThinCrust;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class AbstractPizzaModel implements PizzaModel {
    private Size size;
    private Crust crust;
    protected String name;
    private List<ToppingModel> toppings = new ArrayList<>();
    private IngredientModel ingredient;


    public AbstractPizzaModel() {
        crust = new WheatThinCrust();
        size = Size.REGULAR;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Crust getCrust() {
        return this.crust;
    }

    public List<ToppingModel> getToppings() {
        return toppings;
    }


    public void addToppings(ToppingModel... topping) {
        this.toppings.addAll(Arrays.asList(topping));
    }

    public IngredientModel getIngredient() {
        return ingredient;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append(this.name + " Pizza ")
                .append("of " + getSize().getName()).append(" Size ").append(System.lineSeparator())
                .append("With " + getCrust()).append(" as Crust ").append(System.lineSeparator())
                .append("Having ToppingModel ").append(System.lineSeparator());
        for (ToppingModel topping : this.toppings) {
            result.append(" + ").append(topping).append(System.lineSeparator());
        }
        return result.toString();
    }

    @Override
    public Price cost(Date date) {
        CostData costData = null; //new CostDAO().getCostMap().get("Paneer");
        double price = costData.getPrice();
        String priceCcy = costData.getPriceCcy();
        String priceUOM = costData.getPriceUOM();
        return new Price(price, priceCcy, priceUOM);
    }
}
