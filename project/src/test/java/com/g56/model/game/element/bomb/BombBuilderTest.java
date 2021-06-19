package com.g56.model.game.element.bomb;

import com.g56.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BombBuilderTest {

    @Test
    public void testCreateBomb(){
        BombBuilder bombBuilder = new ParameterizedBombBuilder(1,2,1000,500);
        Bomb bomb = bombBuilder.createBomb(new Position(2,2), Mockito.mock(BombObserver.class), Mockito.mock(BombCreatorObserver.class));
        Assertions.assertEquals(1,bomb.getPower());
        Assertions.assertEquals(2,bomb.getRadius());
        Assertions.assertEquals(1000,bomb.getDuration());
        Assertions.assertEquals(500,bomb.getExplosionDuration());
    }
}
