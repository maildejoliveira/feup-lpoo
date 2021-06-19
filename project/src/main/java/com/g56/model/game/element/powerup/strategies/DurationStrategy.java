package com.g56.model.game.element.powerup.strategies;

import com.g56.model.game.element.creature.Creature;

public class DurationStrategy extends PowerupStrategy{
    public DurationStrategy(int amount) {
        super(amount);
    }

    @Override
    public void execute(Creature creature) {
        creature.setBombDuration(Math.max(creature.getBombDuration() + getAmount(),0));
    }

    @Override
    public int getPowerupType() {
        return 4;
    }
}
