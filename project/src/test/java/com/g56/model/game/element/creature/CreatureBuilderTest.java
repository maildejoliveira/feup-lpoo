package com.g56.model.game.element.creature;

import com.g56.model.game.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatureBuilderTest {
    private CreatureBuilder creatureBuilder;

    @BeforeEach
    public void creatureBuilderInit(){
        this.creatureBuilder=new CreatureBuilder();
        creatureBuilder.setBombPower(1);
        creatureBuilder.setBombRadius(2);
        creatureBuilder.setBombDuration(3);
        creatureBuilder.setExplosionDuration(4);
    }

    @Test
    public void playerTest(){
        Assertions.assertEquals(Player.class, (creatureBuilder).createPlayer(new Position(2,2)).getClass());
    }
    @Test
    public void createPlayerTest(){
        Player player = (creatureBuilder).createPlayer(new Position(2,2));

        Assertions.assertEquals(new Position(2,2),player.getPosition());
        Assertions.assertEquals(1, player.getBombPower());
        Assertions.assertEquals(2, player.getBombRadius());
        Assertions.assertEquals(3,player.getBombDuration());
        Assertions.assertEquals(4,player.getExplosionDuration());
    }

    @Test
    public void enemyTest(){
        Assertions.assertEquals(Enemy.class, (creatureBuilder).createEnemy(new Position(2,2)).getClass());
    }
    @Test
    public void createEnemyTest(){
        Enemy enemy = (creatureBuilder).createEnemy(new Position(2,2));

        Assertions.assertEquals(new Position(2,2),enemy.getPosition());
        Assertions.assertEquals(1, enemy.getBombPower());
        Assertions.assertEquals(2, enemy.getBombRadius());
        Assertions.assertEquals(3,enemy.getBombDuration());
        Assertions.assertEquals(4,enemy.getExplosionDuration());
    }
}
