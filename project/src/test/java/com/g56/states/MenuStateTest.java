package com.g56.states;

import com.g56.controller.menu.MenuController;
import com.g56.controller.menu.ResultMenuController;
import com.g56.gui.LanternaGUI;
import com.g56.model.menu.LooserMenu;
import com.g56.model.menu.Menu;
import com.g56.viewer.menu.MenuViewer;
import com.g56.viewer.menu.ResultMenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuStateTest {
    private MenuState menuState;

    @BeforeEach
    public void initState() throws FontFormatException, IOException, URISyntaxException {
        menuState = new MenuState(new Menu());
    }

    @Test
    public void testDimensions() throws FontFormatException, IOException, URISyntaxException {
        Assertions.assertEquals(menuState.getGui().getClass(), LanternaGUI.class);
    }

    @Test
    public void testViewer(){
        Assertions.assertEquals(menuState.getViewer().getClass(), MenuViewer.class);
    }

    @Test
    public void testController(){
        Assertions.assertEquals(menuState.getController().getClass(), MenuController.class);
    }
}
