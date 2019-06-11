package com.pizza.builder;

import com.pizza.exception.ApplicationException;
import com.pizza.model.sides.SidesModel;

public interface SidesModelBuilder {
    <T extends SidesModel> T build(BuildContext context) throws ApplicationException;
}
