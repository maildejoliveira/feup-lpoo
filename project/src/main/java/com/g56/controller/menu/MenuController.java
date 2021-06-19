package com.g56.controller.menu;

import com.g56.Game;
import com.g56.controller.Controller;
import com.g56.gui.GUI;
import com.g56.model.game.field.FileFieldBuilder;
import com.g56.model.menu.Menu;
import com.g56.states.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action){
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case ENTER:
                if(getModel().isStartSelected()) game.setState(new GameState(new FileFieldBuilder("1").createField()));
                if(getModel().isExitSelected()) game.setState(null);
                break;
        }
    }
}
