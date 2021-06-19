package com.g56.states;

import com.g56.Game;
import com.g56.controller.menu.ResultMenuController;
import com.g56.gui.LanternaGUI;
import com.g56.model.menu.LooserMenu;
import com.g56.viewer.menu.ResultMenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ResultStateTest {
    private ResultState resultState;

    @BeforeEach
    public void initState() throws FontFormatException, IOException, URISyntaxException {
        resultState = new ResultState(new LooserMenu());
    }

    @Test
    public void testDimensions() throws FontFormatException, IOException, URISyntaxException {
        Assertions.assertEquals(resultState.getGui().getClass(), LanternaGUI.class);
    }

    @Test
    public void testViewer(){
        Assertions.assertEquals(resultState.getViewer().getClass(), ResultMenuViewer.class);
    }

    @Test
    public void testController(){
        Assertions.assertEquals(resultState.getController().getClass(), ResultMenuController.class);
    }
}
