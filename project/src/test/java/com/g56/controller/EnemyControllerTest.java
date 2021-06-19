package com.g56.controller;

import com.g56.Game;
import com.g56.controller.game.EnemyController;
import com.g56.controller.game.movestrategies.MoveStrategy;
import com.g56.gui.GUI;
import com.g56.model.game.Position;
import com.g56.model.game.element.creature.CreatureBuilder;
import com.g56.model.game.element.creature.Enemy;
import com.g56.model.game.field.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

public class EnemyControllerTest {
    Field field;
    EnemyController controller;
    Enemy enemy;
    MoveStrategy moveStrategy;

    @BeforeEach
    public void setUp(){
        field = Mockito.mock(Field.class);
        controller = new EnemyController(field);
        enemy = Mockito.mock(Enemy.class);
        moveStrategy = Mockito.mock(MoveStrategy.class);
        controller.associateEnemy(enemy,moveStrategy);
    }

    @Test
    public void verifyAssociate(){
        Mockito.verify(enemy,Mockito.times(1)).setObserver(controller);
        Mockito.verify(field,Mockito.times(1)).addEnemy(enemy);
    }

    @Test
    public void testEnemyStep() throws IOException {
        Mockito.when(field.positionIsEmpty(Mockito.any(Position.class))).thenReturn(true);

        controller.associateEnemy(enemy,moveStrategy);
        controller.step(Mockito.mock(Game.class), GUI.ACTION.BOMB, 0);
        Mockito.verify(enemy, Mockito.atLeast(1)).getLife();
        Mockito.verify(enemy, Mockito.atLeast(1)).getPosition();
        Mockito.verify(enemy, Mockito.times(0)).decrementTimeToPlaceBomb();

        controller.associateEnemy(enemy,moveStrategy);
        controller.step(Mockito.mock(Game.class), GUI.ACTION.BOMB, 100);
        Mockito.verify(enemy, Mockito.atLeast(1)).getLife();
        Mockito.verify(enemy, Mockito.atLeast(1)).getPosition();
        Mockito.verify(enemy, Mockito.times(0)).decrementTimeToPlaceBomb();

        controller.associateEnemy(enemy,moveStrategy);
        Mockito.when(enemy.getLife()).thenReturn(10);
        controller.step(Mockito.mock(Game.class), GUI.ACTION.BOMB, 1000);

        Mockito.verify(enemy, Mockito.atLeast(1)).getLife();
        Mockito.verify(enemy, Mockito.atLeast(1)).getPosition();
        Mockito.verify(enemy, Mockito.atLeast(1)).decrementTimeToPlaceBomb();
    }

    @Test
    public void testPlaceBomb(){
        controller.readyToPlaceBomb();
        Mockito.verify(field,Mockito.times(1)).haveBomb(Mockito.any());
        Mockito.verify(enemy, Mockito.times(1)).setTimeToPlaceBomb(Mockito.any(Integer.class));
    }
}
