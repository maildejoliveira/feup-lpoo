package com.g56.controller.game.factory;

import com.g56.controller.game.BombController;
import com.g56.model.game.field.Field;

public class BombControllerFactory extends ControllerFactory{
    @Override
    protected BombController createController(Field field) {
        return new BombController(field);
    }
}
