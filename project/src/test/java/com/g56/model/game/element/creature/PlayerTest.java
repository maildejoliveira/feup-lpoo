package com.g56.model.game.element.creature;

import com.g56.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setPlayer(){
        Position p = new Position(10,10);
        player = new Player(p,10);
    }

    @Test
    public void testGetPosition(){
        Assertions.assertEquals(new Position(10,10),player.getPosition());
    }

    @Test
    public void testSetPosition(){
        Position p = new Position(5,10);
        player.setPosition(p);
        Assertions.assertEquals(new Position(5,10),player.getPosition());
    }

    @Test
    public void testBombConfigs(){
        player.setBombPower(2);
        Assertions.assertEquals(2, player.getBombPower());

        player.setBombRadius(3);
        Assertions.assertEquals(3, player.getBombRadius());

        player.setBombDuration(4);
        Assertions.assertEquals(4, player.getBombDuration());

        player.setExplosionDuration(2);
        Assertions.assertEquals(2, player.getExplosionDuration());
    }

    @Test
    public void testGetLife(){
        Assertions.assertEquals(10,player.getLife());
    }
}


