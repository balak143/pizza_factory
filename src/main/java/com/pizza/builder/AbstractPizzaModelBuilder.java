package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.exception.ThrowingConsumer;
import com.pizza.input.PizzaInputData;
import com.pizza.model.crust.AbstractCrustModel;
import com.pizza.model.crust.CrustModelFactory;
import com.pizza.model.crust.CrustName;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.service.ingredient.IngredientQtyDeriveService;
import com.pizza.model.pizza.ingredients.IngredientRequiredQty;
import com.pizza.model.pizza.ingredients.PizzaIngredientsName;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.ToppingModelFactory;
import com.pizza.model.topping.ToppingName;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPizzaModelBuilder<T extends AbstractPizzaModel> implements PizzaModelBuilder {
    private PizzaInputData pizzaInputData;

    public AbstractPizzaModelBuilder(PizzaInputData pizzaInputData) {
        this.pizzaInputData = pizzaInputData;
    }

    public PizzaInputData getPizzaInputData() {
        return pizzaInputData;
    }


    protected abstract double getMultiplier();

    protected IngredientModel buildIngredientModel(String name) throws ApplicationException {
        IngredientRequiredQty ingredientRequiredQty = getIngredientRequiredQty(name);
        return new IngredientModel(ingredientRequiredQty.getName(), ingredientRequiredQty.getType(), ingredientRequiredQty.getQty()
                * getMultiplier(), ingredientRequiredQty.getQtyUom());
    }


    protected IngredientRequiredQty getIngredientRequiredQty(String productName) throws ApplicationException {
        IngredientRequiredQty requiredQty = IngredientQtyDeriveService.getInstance().getQty(productName);
        return requiredQty;
    }

    protected abstract AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException;

    /**
     * Add minimum basic ingredients to any pizza
     *
     * @param ingredientsModel
     * @throws ApplicationException
     */
    protected void addBasicIngredients(AbstractPizzaIngredientsModel ingredientsModel) throws ApplicationException {
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.SAUCE.getName()));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.CHEESE.getName()));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.PEPPERONI.getName()));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.RED_PEPPER.getName()));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.OREGANO.getName()));
        ingredientsModel.add(buildIngredientModel(PizzaIngredientsName.GARLIC.getName()));
    }


    @Override
    public AbstractPizzaModel build(BuildContext context) throws ApplicationException {
        AbstractPizzaModel model = createPizzaModel();
        String pizzaSize = getPizzaInputData().getPizzaSize();
        model.setSize(Size.of(pizzaSize));
        model.setPizzaIngredientsModel(buildPizzaIngredientModel());
        model.setName(getPizzaInputData().getName());
        model.setCrustModel(buildCrustModel());
        model.setToppings(buildToppingModels());
        return model;
    }

    protected AbstractCrustModel buildCrustModel() throws ApplicationException {
        CrustName crustName = CrustName.of(getPizzaInputData().getCrustName());
        AbstractCrustModel crustModel = CrustModelFactory.getInstance().createCrustModel(crustName);
        crustModel.setIngredientModel(buildIngredientModel(crustName.getName()));
        return crustModel;
    }


    private List<AbstractToppingModel> buildToppingModels() {
        List<AbstractToppingModel> toppingModels = new ArrayList<>();
        List<String> toppings = getPizzaInputData().getToppings();
        toppings.forEach(topping -> {
            ToppingName toppingName = ToppingName.of(topping);
            IngredientRequiredQty ingredientRequiredQty = null;
            try {
                AbstractToppingModel toppingModel = ToppingModelFactory.getInstance().createToppingModel(toppingName);
                toppingModel.setIngredientModel(buildIngredientModel(toppingName.getName()));
                toppingModels.add(toppingModel);
            } catch (ApplicationException e) {
                ThrowingConsumer.sneakyThrow(e);
            }
        });
        return toppingModels;
    }

    protected abstract T createPizzaModel();

    protected abstract IngredientType getPizzaType();

}
