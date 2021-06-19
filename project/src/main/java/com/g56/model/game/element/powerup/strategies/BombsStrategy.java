package com.g56.model.game.element.powerup.strategies;

import com.g56.model.game.element.creature.Creature;

public class BombsStrategy extends PowerupStrategy{
    public BombsStrategy(int amount) {
        super(amount);
    }

    @Override
    public void execute(Creature creature) {
        creature.setBombsNumber(Math.max(creature.getBombsNumber() + getAmount(),0));
    }

    @Override
    public int getPowerupType() {
        return 1;
    }
}
