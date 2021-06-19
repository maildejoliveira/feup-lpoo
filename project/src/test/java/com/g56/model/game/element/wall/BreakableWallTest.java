package com.g56.model.game.element.wall;

import com.g56.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BreakableWallTest {
    private BreakableWall breakableWall;

    @BeforeEach
    public void setUpBreakableWall(){
        breakableWall = new BreakableWall(new Position(10,10),4);
    }

    @Test
    public void testCanBeDestroyed(){
        Assertions.assertTrue(breakableWall.canBeDestroyed());
    }

    @Test
    public void testGetDurability(){
        Assertions.assertEquals(4,breakableWall.getDurability());
    }

    @Test
    public void testSetDurability(){
        breakableWall.setDurability(5);
        Assertions.assertEquals(5,breakableWall.getDurability());
    }

    @Test
    public void testWallSurvivesExplosion(){
        Assertions.assertEquals(false,breakableWall.explode(3));
    }

    @Test
    public void testWallDestroyedByExplosion(){
         WallObserver bombObserverStub =  Mockito.mock(WallObserver.class);

         breakableWall.setObserver(bombObserverStub);
         breakableWall.explode(5);

         Mockito.verify(bombObserverStub,Mockito.times(1)).toRemove(breakableWall);
    }
}
