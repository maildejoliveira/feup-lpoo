package com.g56.states;

import com.g56.controller.Controller;
import com.g56.controller.menu.MenuController;
import com.g56.gui.GUI;
import com.g56.gui.LanternaGUI;
import com.g56.model.menu.Menu;
import com.g56.viewer.Viewer;
import com.g56.viewer.menu.MenuViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuState extends State<Menu> {
    public MenuState(Menu menu) throws FontFormatException, IOException, URISyntaxException {
        super(menu);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

    @Override
    protected GUI getGui() throws FontFormatException, IOException, URISyntaxException {
        return new LanternaGUI(11,11);
    }
}
