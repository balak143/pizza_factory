package com.pizza.validator.pizza;

import com.pizza.exception.ApplicationException;
import com.pizza.model.ingredient.IngredientModel;
import com.pizza.model.ingredient.IngredientType;
import com.pizza.model.pizza.AbstractPizzaModel;
import com.pizza.model.topping.AbstractToppingModel;
import com.pizza.model.topping.ToppingName;
import com.pizza.utils.MessageResourceUtil;
import com.pizza.validator.crust.CrustModelValidator;
import com.pizza.validator.topping.ToppingModelValidator;

import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * AbstractPizzaModel validator to validate both crust and toppings.
 * Can create similar specific validators for different pizza if required
 * @param <T>
 */
public abstract class AbstractPizzaModelValidator<T extends AbstractPizzaModel> implements PizzaModelValidator<T> {
    private ToppingModelValidator toppingModelValidator;
    private CrustModelValidator crustModelValidator;

    public ToppingModelValidator getToppingModelValidator() {
        return toppingModelValidator;
    }

    public void setToppingModelValidator(ToppingModelValidator toppingModelValidator) {
        this.toppingModelValidator = toppingModelValidator;
    }

    public CrustModelValidator getCrustModelValidator() {
        return crustModelValidator;
    }

    public void setCrustModelValidator(CrustModelValidator crustModelValidator) {
        this.crustModelValidator = crustModelValidator;
    }

    @Override
    public void validate(AbstractPizzaModel pizzaModel) throws ApplicationException {
        validateCrust(pizzaModel);
        validateToppings(pizzaModel);
    }

    private void validateCrust(AbstractPizzaModel pizzaModel) throws ApplicationException {
        if (pizzaModel.getCrustModel() == null) {
            throw new ApplicationException(MessageResourceUtil.getMessage(("AbstractPizzaModelValidator.validateCrust.001")));

        }
    }

    private void validateToppings(AbstractPizzaModel pizzaModel) throws ApplicationException {
        List<AbstractToppingModel> toppingModels = pizzaModel.getToppings();
        if (toppingModels == null || toppingModels.isEmpty()) {
            return;
        }
        for (AbstractToppingModel toppingModel : toppingModels) {
            IngredientModel ingredientModel = toppingModel.getIngredientModel();
            if (ingredientModel == null) {
                throw new ApplicationException("Ingredient model not found for - " + toppingModel.getName());
            }
            vegPizzaCantHaveNonVegTopping(pizzaModel, toppingModel);
            nonvegPizzaCantHavePaneerTopping(pizzaModel, toppingModel);
        }

        onlyOneNonVegToppingAllowedOnNonvegPizza(pizzaModel, toppingModels);
    }

    private void onlyOneNonVegToppingAllowedOnNonvegPizza(AbstractPizzaModel pizzaModel, List<AbstractToppingModel> toppingModels) throws ApplicationException {
        long noOfNonVegToppings = toppingModels.stream().filter(abstractToppingModel ->
                abstractToppingModel.getIngredientModel().getType() == IngredientType.NON_VEG).count();

        if (noOfNonVegToppings > 1L && pizzaModel.getPizzaType() == IngredientType.NON_VEG) {
            throw new ApplicationException(MessageResourceUtil.getMessage("AbstractPizzaModelValidator.validateToppings.onlyOneNonVegToppingAllowedOnNonvegPizza.001"));
        }
    }

    private void nonvegPizzaCantHavePaneerTopping(AbstractPizzaModel pizzaModel, AbstractToppingModel toppingModel) throws ApplicationException {
        if (pizzaModel.getPizzaType() == IngredientType.NON_VEG &&
                toppingModel.getIngredientModel().getProductCode().equals(ToppingName.PANEER.getName())) {
            throw new ApplicationException(MessageResourceUtil
                    .getMessage("AbstractPizzaModelValidator.validateToppings.nonvegPizzaCantHavePaneerTopping.001",
                            new String[]{pizzaModel.getName(), toppingModel.getName()}));

        }
    }

    private void vegPizzaCantHaveNonVegTopping(AbstractPizzaModel pizzaModel, AbstractToppingModel toppingModel) throws ApplicationException {
        IngredientModel ingredientModel = toppingModel.getIngredientModel();

        if (pizzaModel.getPizzaType() == IngredientType.VEG &&
                ingredientModel.getType() == IngredientType.NON_VEG) {

            throw new ApplicationException(
                    MessageResourceUtil.getMessage(
                            "AbstractPizzaModelValidator.validateToppings.vegPizzaCantHaveNonVegTopping.001",
                            new String[]{pizzaModel.getName(), toppingModel.getName()}));
        }
    }


}
