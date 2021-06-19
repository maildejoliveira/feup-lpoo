package com.g56.states;

import com.g56.controller.Controller;
import com.g56.controller.game.FieldController;
import com.g56.controller.game.factory.FieldControllerFactory;
import com.g56.gui.GUI;
import com.g56.gui.LanternaGUI;
import com.g56.model.game.field.Field;
import com.g56.viewer.Viewer;
import com.g56.viewer.game.FieldViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameState extends State<Field> {
    public GameState(Field field) throws FontFormatException, IOException, URISyntaxException {
        super(field);
    }

    @Override
    protected Viewer<Field> getViewer() {
        return new FieldViewer(getModel());
    }

    @Override
    protected Controller<Field> getController() {
        return new FieldControllerFactory().createController(getModel()) ;
    }

    @Override
    protected GUI getGui() throws FontFormatException, IOException, URISyntaxException {
        return new LanternaGUI(getModel().getWidth(),getModel().getHeight()+2);
    }
}
