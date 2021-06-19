package com.g56.controller;

import com.g56.Game;
import com.g56.controller.game.PlayerController;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.Bomb;
import com.g56.model.game.element.bomb.BombObserver;
import com.g56.model.game.element.creature.CreatureBuilder;
import com.g56.model.game.element.wall.BreakableWall;
import com.g56.model.game.element.wall.SolidWall;
import com.g56.model.game.element.wall.Wall;
import com.g56.model.game.field.BasicFieldBuilder;
import com.g56.model.game.field.Field;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerControllerTest {
    private Field field;
    private PlayerController controller;
    private CreatureBuilder builder;

    @BeforeEach
    public void initiateField(){
        field = new Field(10,10, 0);
        builder = new CreatureBuilder();
        builder.setBombPower(1);
        builder.setBombRadius(1);
        builder.setBombDuration(1);
        builder.setExplosionDuration(1);
    }

    @Test
    public void testMovePlayerLeft(){
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.LEFT,0);
        Assertions.assertEquals(new Position(4, 5), field.getPlayer().getPosition());
    }

    @Test
    public void testMovePlayerRight(){
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(6, 5), field.getPlayer().getPosition());
    }

    @Test
    public void testMovePlayerUp(){
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.UP,0);
        Assertions.assertEquals(new Position(5,4), field.getPlayer().getPosition());
    }

    @Test
    public void testMovePlayerDown(){
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.DOWN,0);
        Assertions.assertEquals(new Position(5,6), field.getPlayer().getPosition());
    }

    @Test
    public void testMovePlayerInvalid(){
        field.setPlayer(builder.createPlayer(new Position(0,0)));
        controller = new PlayerController(field);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.UP,0);
        Assertions.assertEquals(new Position(0,0), field.getPlayer().getPosition());
        controller.step(Mockito.mock(Game.class),GUI.ACTION.LEFT,0);
        Assertions.assertEquals(new Position(0,0), field.getPlayer().getPosition());


        field.setPlayer(builder.createPlayer(new Position(9,9)));

        controller.step(Mockito.mock(Game.class),GUI.ACTION.DOWN,0);
        Assertions.assertEquals(new Position(9,9), field.getPlayer().getPosition());
        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(9,9), field.getPlayer().getPosition());
    }

    @Test
    public void testMovePlayerWithWallsDR(){
        field.setPlayer(builder.createPlayer(new Position(0,0)));
        controller = new PlayerController(field);

        Wall wallStub1 = Mockito.mock(BreakableWall.class);
        Position wall1Pos = new Position(1,0);
        Mockito.when(wallStub1.getPosition()).thenReturn(wall1Pos);

        Wall wallStub2 = Mockito.mock(SolidWall.class);
        Position wall2Pos = new Position(0,1);
        Mockito.when(wallStub2.getPosition()).thenReturn(wall2Pos);

        HashMap<Position,Wall> map = new HashMap<>();

        map.put(wall1Pos,wallStub1);
        map.put(wall2Pos,wallStub2);
        field.setWalls(map);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.DOWN,0);
        Assertions.assertEquals(new Position(0,0), field.getPlayer().getPosition());
        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(0,0), field.getPlayer().getPosition());
    }

    @Test
    public void testMovePlayerWithWallsUL(){
        field.setPlayer(builder.createPlayer(new Position(9,9)));
        controller = new PlayerController(field);

        Wall wallStub1 = Mockito.mock(BreakableWall.class);
        Position wall1Pos = new Position(8,9);
        Mockito.when(wallStub1.getPosition()).thenReturn(wall1Pos);

        Wall wallStub2 = Mockito.mock(SolidWall.class);
        Position wall2Pos = new Position(9,8);
        Mockito.when(wallStub2.getPosition()).thenReturn(wall2Pos);

        HashMap<Position,Wall> map = new HashMap<>();

        map.put(wall1Pos,wallStub1);
        map.put(wall2Pos,wallStub2);
        field.setWalls(map);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.UP,0);
        Assertions.assertEquals(new Position(9,9), field.getPlayer().getPosition());
        controller.step(Mockito.mock(Game.class),GUI.ACTION.LEFT,0);
        Assertions.assertEquals(new Position(9,9), field.getPlayer().getPosition());
    }

    @Test
    public void testMovePlayerWithWallValid(){
        field.setPlayer(builder.createPlayer(new Position(0,0)));
        controller = new PlayerController(field);

        Wall wallStub1 = Mockito.mock(BreakableWall.class);
        Position wall1Pos = new Position(1,1);
        Mockito.when(wallStub1.getPosition()).thenReturn(wall1Pos);
        HashMap<Position,Wall> map = new HashMap<>();
        map.put(wall1Pos,wallStub1);
        field.setWalls(map);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.DOWN,0);
        Assertions.assertEquals(new Position(0,1), field.getPlayer().getPosition());
        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(0,1), field.getPlayer().getPosition());
    }

    @Test
    public void testExecuteAction(){
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.LEFT,0);
        Assertions.assertEquals(new Position(4,5), field.getPlayer().getPosition());

        controller.step(Mockito.mock(Game.class),GUI.ACTION.DOWN,0);
        Assertions.assertEquals(new Position(4,6), field.getPlayer().getPosition());

        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(new Position(5,6), field.getPlayer().getPosition());

        controller.step(Mockito.mock(Game.class),GUI.ACTION.UP,0);
        Assertions.assertEquals(new Position(5,5), field.getPlayer().getPosition());

        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,0);
        Assertions.assertEquals(1,field.getBombs().size());
    }

    @Test
    public void testPlaceBomb() {
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);

        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,0);
        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,0);
        Assertions.assertEquals(1,field.getBombs().size());
        Assertions.assertEquals(10,field.getPlayer().getLife());

        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,0);
        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,0);
        Assertions.assertEquals(1,field.getBombs().size());
        Assertions.assertEquals(10,field.getPlayer().getLife());

        controller.bombExplode();
        controller.step(Mockito.mock(Game.class),GUI.ACTION.BOMB,0);
        Assertions.assertEquals(2,field.getBombs().size());
        Assertions.assertEquals(10,field.getPlayer().getLife());
    }

    @Test
    public void testMoveWithExplosion() throws InterruptedException {
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);
        Bomb bomb = new Bomb(new Position(6,5),1,1,1000,5000);
        bomb.setObserver(Mockito.mock(BombObserver.class));
        bomb.setCreatorObserver(controller);
        bomb.changeState();
        bomb.createExplosion(new Position(6,5));
        field.addBomb(bomb);

        Assertions.assertEquals(10,field.getPlayer().getLife());
        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(9,field.getPlayer().getLife());

    }

    @Test
    public void testMoveWithBomb() throws InterruptedException {
        field.setPlayer(builder.createPlayer(new Position(5,5)));
        controller = new PlayerController(field);
        Bomb bomb = new Bomb(new Position(6,5),1,1,1000,5000);
        bomb.createExplosion(new Position(6,5));
        field.addBomb(bomb);

        Assertions.assertEquals(10,field.getPlayer().getLife());
        controller.step(Mockito.mock(Game.class),GUI.ACTION.RIGHT,0);
        Assertions.assertEquals(10,field.getPlayer().getLife());

    }

    @Property
    void playerDoesNotLeave(
            @ForAll @IntRange(min = 3, max = 50) int width,
            @ForAll @IntRange(min = 3, max = 50) int height,
            @ForAll List<GUI.@From("moveActions") ACTION> actions){

        BasicFieldBuilder fieldBuilder = new BasicFieldBuilder(width,height);
        field = fieldBuilder.createField();
        controller = new PlayerController(field);

        for(GUI.ACTION action : actions) {
            controller.step(Mockito.mock(Game.class),action,0);
            assert (controller.getModel().getPlayer().getPosition().getX() > 0);
            assert (controller.getModel().getPlayer().getPosition().getY() > 0);
            assert (controller.getModel().getPlayer().getPosition().getX() < width - 1);
            assert (controller.getModel().getPlayer().getPosition().getY() < height - 1);
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }

}
