package com.g56.model.game.element.bomb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ExplodedBombStateTest {
    private Bomb bombStub;
    private ExplodedBombState explodedBombState;
    private BombObserver observer;

    @BeforeEach
    public void setBombStub(){
        bombStub = Mockito.mock(Bomb.class);
        observer = Mockito.mock(BombObserver.class);
        Mockito.when(bombStub.getObserver()).thenReturn(observer);
        explodedBombState = new ExplodedBombState(bombStub);
    }

    @Test
    public void testTimeToChange(){
        explodedBombState.timeToChange(System.currentTimeMillis());
        Mockito.verify(bombStub,Mockito.times(1)).getPlaceTime();
    }

    @Test
    public void testIsExploded(){
        Assertions.assertTrue(explodedBombState.isExploded());
    }
}
