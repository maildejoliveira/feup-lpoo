package com.g56.model.game.element.powerup.strategies;

import com.g56.model.game.element.creature.Creature;

public class RadiusStrategy extends PowerupStrategy{
    public RadiusStrategy(int amount) {
        super(amount);
    }

    @Override
    public void execute(Creature creature) {
        creature.setBombRadius(Math.max(creature.getBombRadius() + getAmount(),0));
    }

    @Override
    public int getPowerupType() {
        return 0;
    }
}
