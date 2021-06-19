package com.g56.viewer.game;

import com.g56.gui.LanternaGUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.powerup.strategies.BombsStrategy;
import com.g56.model.game.element.powerup.strategies.LifeStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerupViewerTest {
    private LanternaGUI stubGUI;
    private PowerupViewer powerupViewer;
    private Powerup powerup;


    @BeforeEach
    public void initViewers(){
        stubGUI = Mockito.mock(LanternaGUI.class);

        powerupViewer = new PowerupViewer();

        powerup = new Powerup(new Position(5,5),1000);
    }

    @Test
    public void drawIncrementPowerup(){
        powerup.setStrategy(new LifeStrategy(2));

        powerupViewer.drawElement(powerup,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor("#8AFF8C");
        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#FC4248");
        Mockito.verify(stubGUI,Mockito.times(1)).drawPowerup(powerup.getPosition().getX(),powerup.getPosition().getY()+2, powerup.getPowerupType());
        Mockito.verify(stubGUI,Mockito.times(0)).setDefaultBackground();
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }

    @Test
    public void drawDecrementPowerup(){
        powerup.setStrategy(new BombsStrategy(-2));

        powerupViewer.drawElement(powerup,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#8AFF8C");
        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor("#FC4248");
        Mockito.verify(stubGUI,Mockito.times(1)).drawPowerup(powerup.getPosition().getX(),powerup.getPosition().getY()+2, powerup.getPowerupType());
        Mockito.verify(stubGUI,Mockito.times(0)).setDefaultBackground();
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }
}
