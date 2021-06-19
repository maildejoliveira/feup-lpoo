package com.g56.controller;

import com.g56.Game;
import com.g56.controller.game.*;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Player;
import com.g56.model.game.field.Field;
import com.g56.states.MenuState;
import com.g56.states.ResultState;
import com.g56.states.State;
import net.jqwik.api.*;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

public class FieldControllerTest {
    private Field stubField;
    private Game stubGame;
    private PlayerController playerController;
    private BombController bombController;
    private WallController wallController;
    private PowerupController powerupController;
    private EnemyController enemyController;
    private FieldController fieldController;

    @BeforeEach
    public void setUp() throws IOException {
        stubField  = Mockito.mock(Field.class);
        stubGame = Mockito.mock(Game.class);
        playerController = Mockito.mock(PlayerController.class);
        bombController = Mockito.mock(BombController.class);
        wallController = Mockito.mock(WallController.class);
        powerupController = Mockito.mock(PowerupController.class);
        enemyController = Mockito.mock(EnemyController.class);
        fieldController = new FieldController(stubField);
        fieldController.setEnemyControllers(Collections.singletonList(enemyController));
        fieldController.setPowerupController(powerupController);
        fieldController.setWallController(wallController);
        fieldController.setBombController(bombController);
        fieldController.setPlayerController(playerController);
    }

    @Test
    public void FieldStepQuit() throws IOException, URISyntaxException, FontFormatException {
        fieldController.step(stubGame,GUI.ACTION.QUIT,0);

        Mockito.verify(playerController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(bombController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(wallController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(powerupController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(enemyController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
    }

    @Test
    public void FieldStepNoEnemy() throws FontFormatException, IOException, URISyntaxException {
        Mockito.when(stubField.getPlayer()).thenReturn(new Player(new Position(1,1),10));
        Mockito.when(stubField.haveEnemies()).thenReturn(false);

        fieldController.step(stubGame,GUI.ACTION.RIGHT,0);


        Mockito.verify(playerController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(bombController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(wallController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(powerupController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(enemyController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
    }

    @Test
    public void FieldStepNoLife() throws FontFormatException, IOException, URISyntaxException {
        Mockito.when(stubField.getPlayer()).thenReturn(new Player(new Position(1,1),0));
        Mockito.when(stubField.haveEnemies()).thenReturn(true);

        fieldController.step(stubGame,GUI.ACTION.RIGHT,0);


        Mockito.verify(playerController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(bombController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(wallController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(powerupController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
        Mockito.verify(enemyController,Mockito.times(0)).step(Mockito.any(Game.class),Mockito.any(GUI.ACTION.class),Mockito.any(Integer.class));
    }

    @Property
    public void FieldStepOk(@ForAll @Positive int time,
                            @ForAll List<GUI.@From("moveActions") ACTION> actions)
            throws FontFormatException, IOException, URISyntaxException {

        setUp();
        Mockito.when(stubField.getPlayer()).thenReturn(new Player(new Position(1, 1), 10));
        Mockito.when(stubField.haveEnemies()).thenReturn(true);


        for(GUI.ACTION action : actions) {
            fieldController.step(stubGame, action, time);

            Mockito.verify(playerController, Mockito.atLeast(1)).step(stubGame, action, time);
            Mockito.verify(bombController, Mockito.atLeast(1)).step(stubGame, action, time);
            Mockito.verify(wallController, Mockito.atLeast(1)).step(stubGame, action, time);
            Mockito.verify(powerupController, Mockito.atLeast(1)).step(stubGame, action, time);
            Mockito.verify(enemyController, Mockito.atLeast(1)).step(stubGame, action, time);
        }
    }


    /*@Property
    public void FieldStepQuit(@ForAll @Positive int time,
                          @ForAll List<GUI.@From("moveActions") ACTION> actions) throws FontFormatException, IOException, URISyntaxException {

        setUp();

        Mockito.doNothing().when(stubGame).setState(Mockito.any(MenuState.class));
        Mockito.doNothing().when(stubGame).setState(Mockito.any(ResultState.class));
        Mockito.when(stubField.getPlayer()).thenReturn(new Player(new Position(1,1),10));

        for(GUI.ACTION action : actions) {
            fieldController.step(stubGame,GUI.ACTION.QUIT,time);

            Mockito.verify(playerController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(bombController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(wallController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(powerupController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(enemyController,Mockito.times(0)).step(stubGame,action,time);
        }


        Mockito.when(stubField.haveEnemies()).thenReturn(true);

        fieldController.step(stubGame,GUI.ACTION.RIGHT,0);

        Mockito.verify(playerController,Mockito.times(1)).step(stubGame,GUI.ACTION.RIGHT,0);
        Mockito.verify(bombController,Mockito.times(1)).step(stubGame,GUI.ACTION.RIGHT,0);
        Mockito.verify(wallController,Mockito.times(1)).step(stubGame,GUI.ACTION.RIGHT,0);
        Mockito.verify(powerupController,Mockito.times(1)).step(stubGame,GUI.ACTION.RIGHT,0);
        Mockito.verify(enemyController,Mockito.times(1)).step(stubGame,GUI.ACTION.RIGHT,0);


        Mockito.when(stubField.getPlayer()).thenReturn(new Player(new Position(1,1),0));

        fieldController.step(stubGame,GUI.ACTION.BOMB,0);

        Mockito.verify(playerController,Mockito.times(0)).step(stubGame,GUI.ACTION.BOMB,0);
        Mockito.verify(bombController,Mockito.times(0)).step(stubGame,GUI.ACTION.BOMB,0);
        Mockito.verify(wallController,Mockito.times(0)).step(stubGame,GUI.ACTION.BOMB,0);
        Mockito.verify(powerupController,Mockito.times(0)).step(stubGame,GUI.ACTION.BOMB,0);
        Mockito.verify(enemyController,Mockito.times(0)).step(stubGame,GUI.ACTION.BOMB,0);
    }


    @Property
    public void FieldStepNoEnemy(@ForAll @Positive int time,
                              @ForAll List<GUI.@From("moveActions") ACTION> actions) throws FontFormatException, IOException, URISyntaxException {

        setUp();

        Mockito.doNothing().when(stubGame).setState(Mockito.any(MenuState.class));
        Mockito.doNothing().when(stubGame).setState(Mockito.any(ResultState.class));
        Mockito.when(stubField.getPlayer()).thenReturn(new Player(new Position(1,1),10));

        for(GUI.ACTION action : actions) {
            fieldController.step(stubGame,action,0);

            Mockito.verify(playerController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(bombController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(wallController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(powerupController,Mockito.times(0)).step(stubGame,action,time);
            Mockito.verify(enemyController,Mockito.times(0)).step(stubGame,action,time);
        }

    }*/

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}
