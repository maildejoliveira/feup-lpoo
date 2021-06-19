package com.g56.model.game.element.powerup.strategies;

import com.g56.model.game.element.creature.Creature;

public class ExplosionDurationStrategy extends PowerupStrategy{

    public ExplosionDurationStrategy(int amount) {
        super(amount);
    }

    @Override
    public void execute(Creature creature) {
        creature.setExplosionDuration(Math.max(creature.getExplosionDuration() + getAmount(),0));
    }

    @Override
    public int getPowerupType() {
        return 5;
    }
}
