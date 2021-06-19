package com.g56.viewer.game;

import com.g56.gui.LanternaGUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.bomb.BombCreatorObserver;
import com.g56.model.game.element.bomb.BombObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BombViewerTest {
    private LanternaGUI stubGUI;
    private BombViewer bombViewer;
    private Bomb bomb;


    @BeforeEach
    public void initViewers(){
        stubGUI = Mockito.mock(LanternaGUI.class);

        bombViewer = new BombViewer();

        bomb = new Bomb(new Position(5,5),1,1,1,1);
        bomb.setObserver(Mockito.mock(BombObserver.class));
        bomb.setCreatorObserver(Mockito.mock(BombCreatorObserver.class));
    }
    @Test
    public void drawBomb() {
        bombViewer.drawElement(bomb,stubGUI);

        Mockito.verify(stubGUI, Mockito.atLeast(1)).drawBomb(bomb.getPosition().getX(), bomb.getPosition().getY()+2);
    }
    @Test
    public void drawExplosions() {
        bomb.changeState();
        bomb.createExplosion(new Position(bomb.getPosition().getX(),bomb.getPosition().getY()));
        bomb.createExplosion(new Position(bomb.getPosition().getX()-1,bomb.getPosition().getY()));
        bomb.createExplosion(new Position(bomb.getPosition().getX()+1,bomb.getPosition().getY()));
        bomb.createExplosion(new Position(bomb.getPosition().getX(),bomb.getPosition().getY()-1));
        bomb.createExplosion(new Position(bomb.getPosition().getX(),bomb.getPosition().getY()+1));
        bombViewer.drawElement(bomb,stubGUI);

        Mockito.verify(stubGUI, Mockito.times(0)).drawBomb(bomb.getPosition().getX(), bomb.getPosition().getY()+2);
        Mockito.verify(stubGUI, Mockito.atLeast(1)).drawExplosion(bomb.getExplosions().get(0).getX(), bomb.getExplosions().get(0).getY()+2);
        Mockito.verify(stubGUI, Mockito.atLeast(1)).drawExplosion(bomb.getExplosions().get(0).getX()-1, bomb.getExplosions().get(0).getY()+2);
        Mockito.verify(stubGUI, Mockito.atLeast(1)).drawExplosion(bomb.getExplosions().get(0).getX()+1, bomb.getExplosions().get(0).getY()+2);
        Mockito.verify(stubGUI, Mockito.atLeast(1)).drawExplosion(bomb.getExplosions().get(0).getX(), bomb.getExplosions().get(0).getY()-1+2);
        Mockito.verify(stubGUI, Mockito.atLeast(1)).drawExplosion(bomb.getExplosions().get(0).getX(), bomb.getExplosions().get(0).getY()+1+2);
    }
}
