package com.g56.model.game.element.creature;

import com.g56.model.game.Position;
import com.g56.model.game.element.bomb.BombObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class EnemyTest {
    private Enemy enemy;

    @BeforeEach
    public void setEnemy(){
        Position p = new Position(10,10);
        enemy = new Enemy(p,10);
    }

    @Test
    public void testGetPosition(){
        Assertions.assertEquals(new Position(10,10),enemy.getPosition());
    }

    @Test
    public void testSetPosition(){
        Position p = new Position(5,10);
        enemy.setPosition(p);
        Assertions.assertEquals(new Position(5,10),enemy.getPosition());
    }

    @Test
    public void testBombConfigs(){
        enemy.setBombPower(2);
        Assertions.assertEquals(2, enemy.getBombPower());

        enemy.setBombRadius(3);
        Assertions.assertEquals(3, enemy.getBombRadius());

        enemy.setBombDuration(4);
        Assertions.assertEquals(4, enemy.getBombDuration());

        enemy.setExplosionDuration(2);
        Assertions.assertEquals(2, enemy.getExplosionDuration());
    }

    @Test
    public void testGetLife(){
        Assertions.assertEquals(10,enemy.getLife());
    }

    @Test
    public void testDecrementTime(){
        enemy.setTimeToPlaceBomb(10);
        EnemyObserver enemyObserver = Mockito.mock(EnemyObserver.class);
        enemy.setObserver(enemyObserver);

        enemy.decrementTimeToPlaceBomb();
        Mockito.verify(enemyObserver, Mockito.times(0)).readyToPlaceBomb();

        for(int i=0; i<9; i++){
            enemy.decrementTimeToPlaceBomb();
        }

        Mockito.verify(enemyObserver, Mockito.times(1)).readyToPlaceBomb();
    }
}
