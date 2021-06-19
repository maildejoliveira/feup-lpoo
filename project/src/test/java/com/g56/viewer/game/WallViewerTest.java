package com.g56.viewer.game;

import com.g56.gui.LanternaGUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.wall.BreakableWall;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallViewerTest {
    private LanternaGUI stubGUI;
    private WallViewer wallViewer;
    @BeforeEach
    public void initViewers(){
        stubGUI = Mockito.mock(LanternaGUI.class);
        wallViewer = new WallViewer();
    }

    @Test
    public void drawBreakableWall() {
        Wall breakable = new BreakableWall(new Position(5,5), 2);
        wallViewer.drawElement(breakable,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor("#7F4829");
        Mockito.verify(stubGUI, Mockito.times(1)).drawBreakableWall(breakable.getPosition().getX(), breakable.getPosition().getY()+2, breakable.getDurability());
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
        Mockito.verify(stubGUI,Mockito.times(0)).setBackgroundColor("#5B6065");
        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#7B8187");
        Mockito.verify(stubGUI, Mockito.times(0)).drawSolidWall(breakable.getPosition().getX(), breakable.getPosition().getY()+2);
        Mockito.verify(stubGUI,Mockito.times(0)).setDefaultBackground();
    }

    @Test
    public void drawSolidWall(){
        Wall solid = new SolidWall(new Position(5,5));
        wallViewer.drawElement(solid,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#7F4829");
        Mockito.verify(stubGUI, Mockito.times(0)).drawBreakableWall(solid.getPosition().getX(), solid.getPosition().getY()+2, solid.getDurability());
        Mockito.verify(stubGUI,Mockito.times(1)).setBackgroundColor("#5B6065");
        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor("#7B8187");
        Mockito.verify(stubGUI, Mockito.times(1)).drawSolidWall(solid.getPosition().getX(), solid.getPosition().getY()+2);
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultBackground();
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }

    @Test
    public void drawBreakableWallInExplosion() {
        Wall breakable = new BreakableWall(new Position(5,5), 2);
        wallViewer.drawElementWithExplosion(breakable,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#7F4829");
        Mockito.verify(stubGUI,Mockito.times(1)).setBackgroundColor("#FF4F00");
        Mockito.verify(stubGUI, Mockito.times(1)).drawBreakableWall(breakable.getPosition().getX(), breakable.getPosition().getY()+2, breakable.getDurability());
        Mockito.verify(stubGUI,Mockito.times(0)).setDefaultForeground();
        Mockito.verify(stubGUI,Mockito.times(0)).setBackgroundColor("#5B6065");
        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#7B8187");
        Mockito.verify(stubGUI, Mockito.times(0)).drawSolidWall(breakable.getPosition().getX(), breakable.getPosition().getY()+2);
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultBackground();
    }

    @Test
    public void drawSolidWallInExplosion(){
        Wall solid = new SolidWall(new Position(5,5));
        wallViewer.drawElementWithExplosion(solid,stubGUI);

        Mockito.verify(stubGUI,Mockito.times(0)).setForegroundColor("#7F4829");
        Mockito.verify(stubGUI, Mockito.times(0)).drawBreakableWall(solid.getPosition().getX(), solid.getPosition().getY()+2, solid.getDurability());
        Mockito.verify(stubGUI,Mockito.times(1)).setBackgroundColor("#5B6065");
        Mockito.verify(stubGUI,Mockito.times(1)).setForegroundColor("#7B8187");
        Mockito.verify(stubGUI, Mockito.times(1)).drawSolidWall(solid.getPosition().getX(), solid.getPosition().getY()+2);
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultBackground();
        Mockito.verify(stubGUI,Mockito.times(1)).setDefaultForeground();
    }


}
