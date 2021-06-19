package com.g56.controller.game.factory;

import com.g56.controller.game.PlayerController;
import com.g56.model.game.field.Field;

public class PlayerControllerFactory extends ControllerFactory{

    @Override
    protected PlayerController createController(Field field) {
        return new PlayerController(field);
    }
}
