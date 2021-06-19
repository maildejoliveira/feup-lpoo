package com.g56.controller.game.factory;

import com.g56.controller.Controller;
import com.g56.controller.game.FieldController;
import com.g56.model.game.field.Field;

public abstract class ControllerFactory {
    protected abstract Controller<Field> createController(Field field);
}
