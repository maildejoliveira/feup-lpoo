package com.g56.states;

import com.g56.controller.Controller;
import com.g56.controller.menu.MenuController;
import com.g56.controller.menu.ResultMenuController;
import com.g56.gui.GUI;
import com.g56.gui.LanternaGUI;
import com.g56.model.menu.ResultMenu;
import com.g56.viewer.Viewer;
import com.g56.viewer.menu.MenuViewer;
import com.g56.viewer.menu.ResultMenuViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ResultState extends State<ResultMenu>{
    public ResultState(ResultMenu model) throws FontFormatException, IOException, URISyntaxException {
        super(model);
    }

    @Override
    protected Viewer<ResultMenu> getViewer() {
        return new ResultMenuViewer(getModel());
    }

    @Override
    protected Controller<ResultMenu> getController() {
        return new ResultMenuController(getModel());
    }

    @Override
    protected GUI getGui() throws FontFormatException, IOException, URISyntaxException {
        return new LanternaGUI(12,12);
    }
}
