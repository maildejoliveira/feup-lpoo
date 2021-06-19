package com.g56.controller.menu;

import com.g56.Game;
import com.g56.controller.Controller;
import com.g56.gui.GUI;
import com.g56.model.game.field.FileFieldBuilder;
import com.g56.model.menu.Menu;
import com.g56.model.menu.ResultMenu;
import com.g56.states.GameState;
import com.g56.states.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ResultMenuController extends Controller<ResultMenu> {
    public ResultMenuController(ResultMenu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        if(action== GUI.ACTION.ENTER || action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
    }
}
