package com.g56.model.game.element.bomb;

import com.g56.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BombTest {
    private Bomb bomb;

    @BeforeEach
    public void createBomb(){
        this.bomb = new Bomb(new Position(10,10),1,3,1000,1000);
    }

    @Test
    public void testGetRadius(){
        Assertions.assertEquals(3,bomb.getRadius());
    }

    @Test
    public void testGetPower(){
        Assertions.assertEquals(1,bomb.getPower());
    }

    @Test
    public void testGetDuration(){
        Assertions.assertEquals(1000,bomb.getDuration());
    }

    @Test
    public void testGetPlaceTime(){
        Assertions.assertEquals(System.currentTimeMillis(),bomb.getPlaceTime(),10);
    }

    @Test
    public void testGetExplosionDuration(){
        Assertions.assertEquals(1000,bomb.getDuration());
    }

    @Test
    public void testExploded(){
        BombState stubBombState = Mockito.mock(BombState.class);
        bomb.setState(stubBombState);

        bomb.exploded();
        Mockito.verify(stubBombState,Mockito.times(1)).isExploded();
    }

    @Test
    public void testChangeState(){
        BombState stubBombState = Mockito.mock(BombState.class);
        bomb.setState(stubBombState);

        bomb.changeState();
        Mockito.verify(stubBombState,Mockito.times(1)).changeState();
    }

    @Test
    public void testTimeToChange(){
        BombState stubBombState = Mockito.mock(BombState.class);
        bomb.setState(stubBombState);
        long currTime = System.currentTimeMillis();

        bomb.timeToChange(currTime);
        Mockito.verify(stubBombState,Mockito.times(1)).timeToChange(currTime);
    }

    @Test
    public void testExplode(){
        BombState stubBombState = Mockito.mock(BombState.class);
        bomb.setState(stubBombState);

        bomb.explode(bomb.getPower());
        Mockito.verify(stubBombState,Mockito.times(1)).isExploded();
    }

    @Test
    public void testCreateExplosion(){
        bomb.createExplosion(new Position(10,10));
        Assertions.assertEquals(1,bomb.getExplosions().size());
    }

    @Test
    public void equalBomb(){
        bomb = new Bomb(new Position(1,1),1,1,1,1);
        Assertions.assertEquals(bomb,bomb);
        Assertions.assertNotEquals(bomb,new Bomb(new Position(1,1),2,1,1,1));
    }
}
