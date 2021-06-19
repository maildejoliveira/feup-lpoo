package com.g56.model.game.field;

import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.wall.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class FileFieldBuilderTest {
    private FileFieldBuilder fileField;

    @BeforeEach
    public void setBasicField() throws IOException {
        fileField = new FileFieldBuilder("Test");
    }

    @Test
    public void testGetWidth(){
        Assertions.assertEquals(5,fileField.getWidth());
    }

    @Test
    public void testGetHeight(){
        Assertions.assertEquals(5,fileField.getHeight());
    }


    @Test
    public void testCreateWalls(){
        Map<Position, Wall> createdWalls = fileField.createWalls();

        /* The following walls are created, since it's a 3x3 field
         * # # #
         * # 3 #
         * # # #*/

        Assertions.assertEquals(22,createdWalls.size());

        Assertions.assertEquals(0,createdWalls.get(new Position(0,0)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(1,0)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(2,0)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(3,0)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(4,0)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(0,1)).getDurability());
        Assertions.assertEquals(5,createdWalls.get(new Position(1,1)).getDurability());
        Assertions.assertEquals(2,createdWalls.get(new Position(2,1)).getDurability());
        Assertions.assertEquals(4,createdWalls.get(new Position(3,1)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(4,1)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(0,2)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(4,2)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(0,3)).getDurability());
        Assertions.assertEquals(7,createdWalls.get(new Position(1,3)).getDurability());
        Assertions.assertEquals(3,createdWalls.get(new Position(2,3)).getDurability());
        Assertions.assertEquals(8,createdWalls.get(new Position(3,3)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(4,3)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(0,4)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(1,4)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(2,4)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(3,4)).getDurability());
        Assertions.assertEquals(0,createdWalls.get(new Position(4,4)).getDurability());
    }

    @Test
    public void testCreatePlayer(){
        /*Verifies that a player is created in the middle of the field*/
        Assertions.assertEquals(Player.class, fileField.createPlayer().getClass());
        Assertions.assertEquals(new Position(2,2),fileField.createPlayer().getPosition());
    }

    @Test
    public void randomNumber(){
        /*int n = fileField.getRandomNumber();
        Assertions.assertTrue(n < 10);
        Assertions.assertEquals(true,n>=0);*/
    }

    @Test
    public void randomBreakableWall(){
        fileField.addRandomBreakableWall(new Position(2,2));
        Wall wall = fileField.createWalls().get(new Position(2, 2));
        if(wall != null){
            Assertions.assertTrue(wall.canBeDestroyed());
        }
    }
}