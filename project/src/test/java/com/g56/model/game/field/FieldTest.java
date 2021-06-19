package com.g56.model.game.field;

import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.bomb.BombObserver;
import com.g56.model.game.element.creature.CreatureBuilder;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.wall.BreakableWall;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class FieldTest {
    private Field field;

    private Player player;
    /*
    @BeforeEach
    public void initField(){
        field = new Field(20,30, numberOfEnemies);
        player = (new CreatureBuilder(1,2,3,4)
                .createPlayer(new Position(5,5)));
    }

    @Test
    public void testDimensions(){
        Assertions.assertEquals(30,field.getHeight());
        Assertions.assertEquals(20,field.getWidth());
    }

    @Test
    public void testGetPlayer(){
        Assertions.assertNull(field.getPlayer());
        field.setPlayer(player);
        Assertions.assertEquals(player,field.getPlayer());
    }

    @Test
    public void testSetPlayer(){
        field.setPlayer(player);
        Assertions.assertEquals(player,field.getPlayer());
    }

    @Test
    public void testSetGetWalls(){
        List<Wall> walls = new ArrayList<>();

        walls.add(new SolidWall(new Position(0,0)));
        walls.add(new SolidWall(new Position(0,1)));
        walls.add(new BreakableWall(new Position(1,0),3));

        field.setWalls(walls);

        Assertions.assertEquals(3,field.getWalls().size());
    }

    @Test
    public void testPositionEmpty(){
        List<Wall> walls= new ArrayList<>();
        walls.add(new SolidWall(new Position(0,0)));
        field.setWalls(walls);

        Assertions.assertEquals(false, field.positionIsEmpty(new Position(-2,3)));
        Assertions.assertEquals(false, field.positionIsEmpty(new Position(2,-3)));
        Assertions.assertEquals(false, field.positionIsEmpty(new Position(field.getWidth()+3, field.getHeight()+5)));
        Assertions.assertEquals(false, field.positionIsEmpty(new Position(0,0)));

        Assertions.assertEquals(true,field.positionIsEmpty(player.getPosition()));
    }

    @Test
    public void bombTest(){
        List<Bomb> bombs = new ArrayList<>();
        bombs.add(new Bomb(new Position(2,2), 2,2,2,2));
        bombs.add(new Bomb(new Position(3,3), 2,2,2,2));
        bombs.add(new Bomb(new Position(4,4), 2,2,2,2));

        field.setBombs(bombs);
        Assertions.assertEquals(bombs, field.getBombs());

        Bomb bomb = new Bomb(new Position(5,6),1,1,1,1);
        field.addBomb(bomb);
        Assertions.assertEquals(bomb, field.getBombs().get(field.getBombs().size()-1));
    }

    @Test
    public void haveBombTest(){
        field.addBomb(new Bomb(new Position(1,1),1,1,1,1));

        Assertions.assertEquals(false, field.haveBomb(new Position(-2,3)));
        Assertions.assertEquals(false, field.haveBomb(new Position(2,-3)));
        Assertions.assertEquals(false, field.haveBomb(new Position(field.getWidth()+3, field.getHeight()+5)));
        Assertions.assertEquals(false, field.haveBomb(new Position(0,0)));
        Assertions.assertEquals(false,field.haveBomb(player.getPosition()));

        Assertions.assertEquals(true,field.haveBomb(new Position(1,1)));
    }

    @Test
    public void haveExplosionTest(){
        Bomb bomb = new Bomb(new Position(1,1),1,1,1,1);
        bomb.setObserver(Mockito.mock(BombObserver.class));
        bomb.createExplosion(new Position(2,2));
        field.addBomb(bomb);

        Assertions.assertEquals(false, field.haveExplosion(new Position(-2,3)));
        Assertions.assertEquals(false, field.haveExplosion(new Position(2,-3)));
        Assertions.assertEquals(false, field.haveExplosion(new Position(field.getWidth()+3, field.getHeight()+5)));
        Assertions.assertEquals(false, field.haveExplosion(new Position(0,0)));
        Assertions.assertEquals(false,field.haveExplosion(player.getPosition()));
        Assertions.assertEquals(false,field.haveExplosion(new Position(1,1)));

        Assertions.assertEquals(false,field.haveExplosion(new Position(2,2)));
        bomb.changeState();
        Assertions.assertEquals(true,field.haveExplosion(new Position(2,2)));
        Assertions.assertEquals(false,field.haveExplosion(new Position(1,1)));
    }*/


}
