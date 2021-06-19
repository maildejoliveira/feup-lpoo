package com.g56.states;

import com.g56.controller.game.FieldController;
import com.g56.gui.LanternaGUI;
import com.g56.model.game.field.Field;
import com.g56.model.game.field.FileFieldBuilder;
import com.g56.viewer.game.FieldViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameStateTest {
    private GameState gameState;

    @BeforeEach
    public void initState() throws FontFormatException, IOException, URISyntaxException {
        gameState = new GameState(new FileFieldBuilder("Test").createField());
    }

    @Test
    public void testDimensions() throws FontFormatException, IOException, URISyntaxException {
        Assertions.assertEquals(gameState.getGui().getClass(), LanternaGUI.class);
    }

    @Test
    public void testViewer(){
        Assertions.assertEquals(gameState.getViewer().getClass(), FieldViewer.class);
    }

    @Test
    public void testController(){
        Assertions.assertEquals(gameState.getController().getClass(), FieldController.class);
    }
}
