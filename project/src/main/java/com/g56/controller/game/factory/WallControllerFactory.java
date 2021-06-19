package com.g56.controller.game.factory;

import com.g56.controller.game.WallController;
import com.g56.model.game.field.Field;

public class WallControllerFactory extends ControllerFactory{
    @Override
    protected WallController createController(Field field) {
        return new WallController(field);
    }
}
