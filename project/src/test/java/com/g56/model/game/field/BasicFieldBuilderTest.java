package com.g56.model.game.field;

import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.wall.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BasicFieldBuilderTest {
    private BasicFieldBuilder basicField;

    @BeforeEach
    public void setBasicField(){
        basicField = new BasicFieldBuilder(3,3);
    }

    @Test
    public void testGetWidth(){
        Assertions.assertEquals(3,basicField.getWidth());
    }

    @Test
    public void testGetHeight(){
        Assertions.assertEquals(3,basicField.getHeight());
    }


    @Test
    public void testCreateWalls(){
        //List<Wall> createdWalls = basicField.createWalls();

        /* The following walls are created, since it's a 3x3 field
         * # # #
         * # 3 #
         * # # #*/

        //Assertions.assertEquals(9,createdWalls.size());

    }

    @Test
    public void testCreatePlayer(){
        /*Verifies that a player is created in the middle of the field*/
        Assertions.assertEquals(Player.class, basicField.createPlayer().getClass());
        Assertions.assertEquals(new Position(1,1),basicField.createPlayer().getPosition());
    }
}
