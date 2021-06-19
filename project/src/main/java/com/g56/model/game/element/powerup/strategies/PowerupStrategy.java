package com.g56.model.game.element.powerup.strategies;

import com.g56.model.game.element.creature.Creature;

public abstract class PowerupStrategy {
    private final int amount;

    protected PowerupStrategy(int amount) {
        this.amount = amount;
    }

    protected int getAmount() {
        return amount;
    }

    public abstract void execute(Creature creature);

    public abstract int getPowerupType();

    public boolean isIncrement(){ return amount >= 0;}
}
