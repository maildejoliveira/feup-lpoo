package com.g56.model.game.element.wall;

import com.g56.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolidWallTest {
    private SolidWall solidWall;

    @BeforeEach
    public void setSolidWall(){
        solidWall = new SolidWall(new Position(10,10));
    }

    @Test
    public void testCanBeDestroyed(){
        Assertions.assertFalse(solidWall.canBeDestroyed());
    }

    @Test
    public void testGetDurability(){
        Assertions.assertEquals(0,solidWall.getDurability());
    }

    @Test
    public void testExplode(){
        Assertions.assertEquals(false,solidWall.explode(100));
    }
}
