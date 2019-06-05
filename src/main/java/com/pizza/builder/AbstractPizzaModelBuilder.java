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

    protected IngredientModel buildIngredientModel(String productName, IngredientType type, double requiredQty, String uomCode) {
        //Call inventoryGet Service to get the Ingredient type and set
        return new IngredientModel(productName, type, requiredQty, uomCode);

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

    protected IngredientModel getIngredientModel(PizzaIngredientsName pizzaIngredientsName) throws ApplicationException {
        IngredientRequiredQty ingredientRequiredQty = getIngredientRequiredQty(pizzaIngredientsName.getName());
        return buildIngredientModel(pizzaIngredientsName.getName(), IngredientType.VEG, ingredientRequiredQty.getQty()
                * getMultiplier(), ingredientRequiredQty.getQtyUom());
    }


    protected abstract AbstractPizzaIngredientsModel buildPizzaIngredientModel() throws ApplicationException;

    protected void addCommonIngredients(AbstractPizzaIngredientsModel ingredientsModel) throws ApplicationException {
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.SAUCE));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.CHEESE));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.PEPPERONI));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.RED_PEPPER));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.OREGANO));
        ingredientsModel.add(getIngredientModel(PizzaIngredientsName.GARLIC));
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
        IngredientRequiredQty requiredQty = getIngredientRequiredQty(crustName.getName());
        crustModel.setIngredientModel(buildIngredientModel(crustName.getName(), IngredientType.VEG, requiredQty.getQty(), requiredQty.getQtyUom()));
        return crustModel;
    }

    protected IngredientRequiredQty getIngredientRequiredQty(String productName) throws ApplicationException {
        IngredientRequiredQty requiredQty = IngredientQtyDeriveService.getInstance().getQty(productName);
        if (requiredQty == null) {
            throw new ApplicationException("Ingredient is not available for  Product - " + productName);
        }
        return requiredQty;
    }

    private List<AbstractToppingModel> buildToppingModels() {
        List<AbstractToppingModel> toppingModels = new ArrayList<>();
        List<String> toppings = getPizzaInputData().getToppings();
        toppings.forEach(topping -> {
            ToppingName toppingName = ToppingName.of(topping);
            IngredientRequiredQty requiredQty = null;
            try {
                requiredQty = getIngredientRequiredQty(toppingName.getName());
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
