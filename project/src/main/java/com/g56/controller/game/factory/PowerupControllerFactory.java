package com.g56.controller.game.factory;

import com.g56.controller.game.PowerupController;
import com.g56.model.game.field.Field;

public class PowerupControllerFactory extends ControllerFactory{
    @Override
    protected PowerupController createController(Field field) {
        return new PowerupController(field);
    }
}
