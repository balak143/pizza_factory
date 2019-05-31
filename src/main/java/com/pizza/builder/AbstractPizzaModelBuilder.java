package com.pizza.builder;

import com.pizza.input.PizzaInputData;
import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.crust.CrustModelFactory;
import com.pizza.model.crust.CrustName;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.PizzaModelFactory;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.ToppingModelFactory;
import com.pizza.model.topping.ToppingName;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPizzaModelBuilder implements PizzaModelBuilder {
    private PizzaInputData pizzaInputData;

    public AbstractPizzaModelBuilder(PizzaInputData pizzaInputData) {
        this.pizzaInputData = pizzaInputData;
    }

    public PizzaInputData getPizzaInputData() {
        return pizzaInputData;
    }

    protected IngredientModel buildIngredientModel(String productName, IngredientType type, double qty, String uomCode) {
        //Call inventoryGet Service to get the Ingredient type and set
        return new IngredientModel(productName, type, qty, uomCode);

    }

    protected double getMultiplier() {
        Size pizzaSize = Size.valueOf(getPizzaInputData().getPizzaSize());

        if (pizzaSize == Size.LARGE) {
            return 2;
        } else if (pizzaSize == Size.LARGE) {
            return 1.5;
        } else {
            return 1;
        }
    }

    protected abstract PizzaIngredientsModel buildPizzaIngredientModel();

    @Override
    public AbstractPizzaModel build(BuildContext context) {
        AbstractPizzaModel model = PizzaModelFactory.getInstance().createPizzaModel(PizzaName.valueOf(getPizzaInputData().getName()));
        model.setSize(Size.valueOf(getPizzaInputData().getPizzaSize()));
        model.setPizzaIngredientsModel(buildPizzaIngredientModel());
        model.setCrustModel(buildCrustModel());
        model.setToppings(buildToppingModels());
        return model;
    }

    private AbstractCrustModel buildCrustModel() {
        AbstractCrustModel crustModel = CrustModelFactory.getInstance().createCrustModel(CrustName.valueOf(getPizzaInputData().getCrustName()));
        crustModel.setIngredientModel(buildIngredientModel(getPizzaInputData().getCrustName(), IngredientType.VEG, 50.0, "GRAM"));
        return crustModel;
    }

    private List<AbstractToppingModel> buildToppingModels() {
        List<AbstractToppingModel> toppingModels = new ArrayList<>();
        List<String> toppings = getPizzaInputData().getToppings();
        toppings.forEach(topping -> {
            AbstractToppingModel toppingModel = ToppingModelFactory.getInstance().createToppingModel(ToppingName.valueOf(topping));
            toppingModel.setIngredientModel(ToppingName.BARBEQUE_CHICKEN.getIngredientModel());
            toppingModels.add(toppingModel);
        });
        return toppingModels;
    }

}
