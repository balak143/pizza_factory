package com.pizza.model.pizza;

import com.pizza.dao.CostData;
import com.pizza.model.crust.CrustModel;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.topping.ToppingModel;
import com.pizza.utils.Price;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public abstract class AbstractPizzaModel implements PizzaModel {
    private Size size;
    private CrustModel crustModel;
    protected String name;
    private List<ToppingModel> toppings = new ArrayList<>();
    protected PizzaIngredientsModel pizzaIngredientsModel;

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    public void setCrustModel(CrustModel crustModel) {
        this.crustModel = crustModel;
    }

    public CrustModel getCrustModel() {
        return this.crustModel;
    }

    public List<ToppingModel> getToppings() {
        return toppings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPizzaIngredientsModel(PizzaIngredientsModel pizzaIngredientsModel) {
        this.pizzaIngredientsModel = pizzaIngredientsModel;
    }

    public void addToppings(ToppingModel... topping) {
        this.toppings.addAll(Arrays.asList(topping));
    }

    public PizzaIngredientsModel getPizzaIngredientsModel() {
        return pizzaIngredientsModel;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder().append(this.name + " Pizza ")
                .append("of " + getSize().getName()).append(" Size ").append(System.lineSeparator())
                .append("With " + getCrustModel()).append(" as CrustModel ").append(System.lineSeparator())
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
