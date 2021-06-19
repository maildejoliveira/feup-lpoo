package com.g56.viewer.game;

import com.g56.gui.LanternaGUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Player;
import com.g56.viewer.game.PlayerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class PlayerViewerTest {
    private Player player;
    private LanternaGUI stubGUI;
    private PlayerViewer playerViewer;

    @BeforeEach
    public void initViewer(){
        player = new Player(new Position(5,5),10);
        stubGUI = Mockito.mock(LanternaGUI.class);
        playerViewer = new PlayerViewer();
    }

    @Test
    public void drawPlayer(){
        playerViewer.drawElement(player,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor("#00FFEE");
        Mockito.verify(stubGUI,Mockito.times(0)).setBackgroundColor("#F03030");
        Mockito.verify(stubGUI,Mockito.times(0)).setBackgroundColor("#FF4F00");
        Mockito.verify(stubGUI, Mockito.times(1)).drawPlayer(player.getPosition().getX(), player.getPosition().getY()+2);
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }

    @Test
    public void drawPlayerWithBomb(){
        playerViewer.drawElementWithBomb(player,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#00FFEE");
        Mockito.verify(stubGUI,Mockito.times(1)).setBackgroundColor("#F03030");
        Mockito.verify(stubGUI,Mockito.times(0)).setBackgroundColor("#FF4F00");
        Mockito.verify(stubGUI, Mockito.times(1)).drawPlayer(player.getPosition().getX(), player.getPosition().getY()+2);
        Mockito.verify(stubGUI, Mockito.times(1)).setDefaultBackground();
    }

    @Test
    public void drawPlayerWithExplosion(){
        playerViewer.drawElementWithExplosion(player,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#00FFEE");
        Mockito.verify(stubGUI,Mockito.times(0)).setBackgroundColor("#F03030");
        Mockito.verify(stubGUI,Mockito.times(1)).setBackgroundColor("#FF4F00");
        Mockito.verify(stubGUI, Mockito.times(1)).drawPlayer(player.getPosition().getX(), player.getPosition().getY()+2);
        Mockito.verify(stubGUI, Mockito.times(1)).setDefaultBackground();
    }
}
