package com.g56.model.game.element.bomb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ActiveBombStateTest {
    private Bomb bombStub;
    private ActiveBombState activeBombState;
    private BombObserver observer;
    private BombCreatorObserver creatorObserver;

    @BeforeEach
    public void setBombStub(){
        bombStub = Mockito.mock(Bomb.class);
        observer = Mockito.mock(BombObserver.class);
        creatorObserver = Mockito.mock(BombCreatorObserver.class);
        Mockito.when(bombStub.getObserver()).thenReturn(observer);
        Mockito.when(bombStub.getCreatorObserver()).thenReturn(creatorObserver);
        activeBombState = new ActiveBombState(bombStub);
    }


    @Test
    public void testChangeState(){
        activeBombState.changeState();
        Mockito.verify(bombStub,Mockito.times(1)).setState(Mockito.any(ExplodedBombState.class));
        Mockito.verify(observer,Mockito.times(1)).doExplosion(bombStub);
        Mockito.verify(creatorObserver,Mockito.times(1)).bombExplode();

    }

    @Test
    public void testTimeToChange(){
        activeBombState.timeToChange(System.currentTimeMillis());
        Mockito.when(bombStub.getDuration()).thenReturn(1000);
        Mockito.when(bombStub.getObserver()).thenReturn(observer);
        Mockito.verify(bombStub,Mockito.times(1)).getDuration();
        Mockito.verify(bombStub,Mockito.times(1)).getPlaceTime();
        Assertions.assertTrue(activeBombState.timeToChange(0) > 0);
        Assertions.assertFalse(activeBombState.timeToChange(1000) < 0);
        Assertions.assertTrue(activeBombState.timeToChange(2000) < 0);
    }

    @Test
    public void testIsExploded(){
        Assertions.assertFalse(activeBombState.isExploded());
    }
}
