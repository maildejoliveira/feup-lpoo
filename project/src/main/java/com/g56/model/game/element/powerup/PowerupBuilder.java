package com.g56.model.game.element.powerup;

import com.g56.controller.game.PowerupController;
import com.g56.model.game.Position;
import com.g56.model.game.element.powerup.Powerup;
import com.g56.model.game.element.powerup.PowerupObserver;
import com.g56.model.game.element.powerup.strategies.*;
import com.g56.utils.RandomGenerator;

public abstract class PowerupBuilder {

    public Powerup createPowerup(Position position, PowerupObserver observer){
        Powerup powerup = new Powerup(position,getExistenceTime());
        powerup.setStrategy(getStrategy());
        powerup.setObserver(observer);
        return powerup;
    }

    protected abstract PowerupStrategy getStrategy();

    protected abstract int getExistenceTime();
}
