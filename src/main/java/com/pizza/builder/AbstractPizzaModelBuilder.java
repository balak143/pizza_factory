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
import com.pizza.model.pizza.PizzaModelFactory;
import com.pizza.model.pizza.PizzaName;
import com.pizza.model.pizza.Size;
import com.pizza.model.pizza.ingredients.AbstractPizzaIngredientsModel;
import com.pizza.model.pizza.ingredients.IngredientQtyDeriveService;
import com.pizza.model.pizza.ingredients.IngredientRequiredQty;
import com.pizza.model.pizza.ingredients.PizzaIngredientsModel;
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

    protected IngredientModel buildIngredientModel(String productName, IngredientType type, double qty, String uomCode) {
        //Call inventoryGet Service to get the Ingredient type and set
        return new IngredientModel(productName, type, qty, uomCode);

    }

    protected double getMultiplier() {
        Size pizzaSize = Size.of(getPizzaInputData().getPizzaSize());

        if (pizzaSize == Size.LARGE) {
            return 2;
        } else if (pizzaSize == Size.LARGE) {
            return 1.5;
        } else {
            return 1;
        }
    }

    protected abstract AbstractPizzaIngredientsModel buildPizzaIngredientModel();

    @Override
    public AbstractPizzaModel build(BuildContext context) throws ApplicationException {
        AbstractPizzaModel model = createPizzaModel();
        model.setSize(Size.of(getPizzaInputData().getPizzaSize()));
        model.setPizzaIngredientsModel(buildPizzaIngredientModel());
        model.setCrustModel(buildCrustModel());
        model.setToppings(buildToppingModels());
        return model;
    }

    protected AbstractCrustModel buildCrustModel() throws ApplicationException {
        CrustName crustName = CrustName.of(getPizzaInputData().getCrustName());
        AbstractCrustModel crustModel = CrustModelFactory.getInstance().createCrustModel(crustName);
        if (crustModel == null) {
            throw new ApplicationException("Crust - " + getPizzaInputData().getCrustName() + "is not valid ");
        }
        IngredientRequiredQty requiredQty = IngredientQtyDeriveService.getInstance().getQty(crustName.getName());
        if (requiredQty == null) {
            throw new ApplicationException("IngredientRequiredQty is not available for  Crust - " + getPizzaInputData().getCrustName());
        }
        crustModel.setIngredientModel(buildIngredientModel(crustName.getName(), IngredientType.VEG, requiredQty.getQty(), requiredQty.getQtyUom()));
        return crustModel;
    }

    private List<AbstractToppingModel> buildToppingModels() {
        List<AbstractToppingModel> toppingModels = new ArrayList<>();
        List<String> toppings = getPizzaInputData().getToppings();
        toppings.forEach(topping -> {
            ToppingName toppingName = ToppingName.of(topping);
            IngredientRequiredQty requiredQty = null;
            try {
                requiredQty = IngredientQtyDeriveService.getInstance().getQty(toppingName.getName());
                if (requiredQty == null) {
                    throw new ApplicationException("IngredientRequiredQty is not available for  Topping - " + topping);
                }
            } catch (ApplicationException e) {
                ThrowingConsumer.sneakyThrow(e);
            }

            AbstractToppingModel toppingModel = ToppingModelFactory.getInstance().createToppingModel(toppingName);
            toppingModel.setIngredientModel(buildIngredientModel(toppingName.getName(), toppingName.getType(), requiredQty.getQty(), requiredQty.getQtyUom()));
            toppingModels.add(toppingModel);
        });
        return toppingModels;
    }

    protected abstract T createPizzaModel();

    protected abstract IngredientType getPizzaType();

}
