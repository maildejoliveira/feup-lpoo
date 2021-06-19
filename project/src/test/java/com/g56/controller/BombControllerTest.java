package com.g56.controller;

import com.g56.Game;
import com.g56.controller.game.BombController;
import com.g56.model.game.element.bomb.BombBuilder;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.bomb.BombCreatorObserver;
import com.g56.model.game.element.bomb.ParameterizedBombBuilder;
import com.g56.model.game.element.creature.Enemy;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.field.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.HashMap;

public class BombControllerTest {
    private Field field;
    private BombController controller;

    @BeforeEach
    public void initiateField(){
        field = new Field(10,10, 0);
        controller = new BombController(field);
    }

    @Test
    public void testRemoveBomb() throws IOException, InterruptedException {
        Bomb bomb = new ParameterizedBombBuilder(1,1,1000,1000).
                createBomb(Mockito.mock(Position.class),controller,Mockito.mock(BombCreatorObserver.class));
        bomb.changeState();
        field.addBomb(bomb);

        Assertions.assertEquals(1,field.getBombs().size());

        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,System.currentTimeMillis());

        Assertions.assertEquals(1,field.getBombs().size());

        Thread.sleep(1000);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,System.currentTimeMillis());

        Assertions.assertEquals(0,field.getBombs().size());
    }

    @Test
    public void testStep() throws InterruptedException, IOException {
        for(int i = 0; i < 5; i++){
            Bomb bomb = new ParameterizedBombBuilder(1,1,1000,1000).
                    createBomb(Mockito.mock(Position.class),controller,Mockito.mock(BombCreatorObserver.class));;
            field.addBomb(bomb);
        }

        for(Bomb bomb: field.getBombs().values()){
            Assertions.assertFalse(bomb.exploded());
        }

        Thread.sleep(1000);
        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,System.currentTimeMillis());

        for(Bomb bomb: field.getBombs().values()){
            Assertions.assertTrue(bomb.exploded());
        }
    }

   @Test
    public void doExplosion(){
       Bomb bomb = new ParameterizedBombBuilder(1,1,1000,1000).
               createBomb(new Position(1,1),controller,Mockito.mock(BombCreatorObserver.class));

       Player player = Mockito.mock(Player.class);
       Mockito.when(player.explode(1)).thenReturn(true);
       Mockito.when(player.getPosition()).thenReturn(new Position(1,1));
       field.setPlayer(player);

       controller.doExplosion(bomb);

       Mockito.verify(player, Mockito.times(1)).explode(1);

       Mockito.verify(player,Mockito.atLeast(1)).getPosition();
   }

    @Test
    public void doExplosionWithBlockingWall(){
        Bomb bomb = new ParameterizedBombBuilder(1,2,1000,1000).
                createBomb(new Position(1,1),controller,Mockito.mock(BombCreatorObserver.class));

        Player player = Mockito.mock(Player.class);
        Mockito.when(player.explode(1)).thenReturn(true);
        Mockito.when(player.getPosition()).thenReturn(new Position(3,1));
        field.setPlayer(player);

        HashMap<Position,Wall> map = new HashMap<>();
        Wall wall = Mockito.mock(SolidWall.class);
        Mockito.when(wall.explode(1)).thenReturn(false);
        map.put(new Position(2,1),wall);
        field.setWalls(map);

        controller.doExplosion(bomb);

        Mockito.verify(wall, Mockito.times(1)).explode(1);

        Mockito.verify(player, Mockito.times(0)).explode(1);

        Mockito.verify(player,Mockito.atLeast(1)).getPosition();
    }

    @Test
    public void doExplosionAllElements(){
        Bomb bomb = new ParameterizedBombBuilder(1,2,1000,1000).
                createBomb(new Position(1,1),controller,Mockito.mock(BombCreatorObserver.class));


        Enemy enemy = Mockito.mock(Enemy.class);
        Mockito.when(enemy.explode(1)).thenReturn(true);
        Mockito.when(enemy.getPosition()).thenReturn(new Position(2,1));
        field.addEnemy(enemy);

        Powerup powerup = Mockito.mock(Powerup.class);
        Mockito.when(powerup.explode(1)).thenReturn(true);
        Mockito.when(powerup.getPosition()).thenReturn(new Position(3,1));
        field.addPowerup(powerup);

        controller.doExplosion(bomb);

        Mockito.verify(enemy, Mockito.times(1)).explode(1);

        Mockito.verify(powerup, Mockito.times(1)).explode(1);
    }
}
