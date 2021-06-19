package com.g56.model.game.element.powerup.strategies;

import com.g56.model.game.element.creature.Creature;
import com.g56.model.game.element.powerup.strategies.PowerupStrategy;

public class LifeStrategy extends PowerupStrategy {
    public LifeStrategy(int amount) {
        super(Math.abs(amount));
    }

    @Override
    public void execute(Creature creature) {
        creature.setLife(creature.getLife() + getAmount());
    }

    @Override
    public int getPowerupType() {
        return 2;
    }
}
