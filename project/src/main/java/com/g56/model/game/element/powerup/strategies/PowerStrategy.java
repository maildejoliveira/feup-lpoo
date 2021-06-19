package com.g56.model.game.element.powerup.strategies;

import com.g56.model.game.element.creature.Creature;

public class PowerStrategy extends PowerupStrategy{
    public PowerStrategy(int amount) {
        super(amount);
    }

    @Override
    public void execute(Creature creature) {
        creature.setBombPower(Math.max(creature.getBombPower() + getAmount(),0));
    }

    @Override
    public int getPowerupType() {
        return 3;
    }
}
