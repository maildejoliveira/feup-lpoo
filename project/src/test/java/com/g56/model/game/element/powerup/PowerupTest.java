package com.g56.model.game.element.powerup;

import com.g56.model.game.Position;
import com.g56.model.game.element.creature.Creature;
import com.g56.model.game.element.powerup.strategies.PowerupStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PowerupTest {
    private Powerup powerup;
    private PowerupObserver powerupObserver;
    private PowerupStrategy powerupStrategy;

    @BeforeEach
    public void initPowerup(){
        powerup = new Powerup(new Position(2,2),1000);

        powerupObserver = Mockito.mock(PowerupObserver.class);
        powerupStrategy = Mockito.mock(PowerupStrategy.class);

        powerup.setObserver(powerupObserver);
        powerup.setStrategy(powerupStrategy);
    }

    @Test
    public void catchPowerup(){
        Creature creature = Mockito.mock(Creature.class);

        powerup.catchPowerup(creature);

        Mockito.verify(powerupStrategy, Mockito.times(1)).execute(creature);
        Mockito.verify(powerupObserver, Mockito.times(1)).toRemove(powerup);
    }

    @Test
    public void explode(){
        Assertions.assertTrue(powerup.explode(3));
        Mockito.verify(powerupObserver,Mockito.times(1)).toRemove(powerup);
    }

    @Test
    public void timeToRemove() throws InterruptedException {
        Assertions.assertTrue(powerup.timeToRemove(System.currentTimeMillis())>0);
        Thread.sleep(1005);
        Assertions.assertTrue(powerup.timeToRemove(System.currentTimeMillis())<0);

    }

    @Test
    public void powerupType(){
        powerup.getPowerupType();
        Mockito.verify(powerupStrategy, Mockito.times(1)).getPowerupType();
    }

    @Test
    public void isIncrement(){
        powerup.isIncrement();
        Mockito.verify(powerupStrategy, Mockito.times(1)).isIncrement();
    }

}
