package com.g56.controller;

import com.g56.Game;
import com.g56.controller.game.PowerupController;
import com.g56.model.game.element.powerup.PowerupBuilder;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.powerup.RandomPowerupBuilder;
import com.g56.model.game.field.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class PowerupControllerTest {
    private Field field;
    private PowerupController controller;

    @BeforeEach
    public void initiateField(){
        field = new Field(10,10, 0);
        controller = new PowerupController(field);
    }

    @Test
    public void testToRemove(){
        Powerup powerupStub = Mockito.mock(Powerup.class);
        Position powerupPos = new Position(1,1);
        Mockito.when(powerupStub.getPosition()).thenReturn(powerupPos);

        field.addPowerup(powerupStub);

        Assertions.assertEquals(1,field.getPowerups().size());
        controller.toRemove(powerupStub);
        Assertions.assertEquals(0,field.getWalls().size());

    }

    @Test
    public void testPowerupStep() throws InterruptedException, FontFormatException, IOException, URISyntaxException {
        for(int i = 0; i < 5; i++){
            Powerup powerup = new RandomPowerupBuilder().createPowerup(new Position(1,1+i),controller);
            field.addPowerup(powerup);
        }

        controller.step(Mockito.mock(Game.class), GUI.ACTION.BOMB,System.currentTimeMillis());

        Assertions.assertEquals(5, field.getPowerups().size());

        Thread.sleep(20000);
        controller.step(Mockito.mock(Game.class), GUI.ACTION.BOMB,System.currentTimeMillis());

        Assertions.assertEquals(0, field.getPowerups().size());
    }

    @Test
    public void verifyWallWasDestroyed(){
        for (int i = 0; i < 10; i++){
            controller.wallWasDestroyed(Mockito.mock(Position.class));
        }
        Assertions.assertTrue(controller.getModel().getPowerups().size() <= 10);
    }
}
