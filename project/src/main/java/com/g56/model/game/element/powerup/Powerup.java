package com.g56.model.game.element.powerup;

import com.g56.model.game.Position;
import com.g56.model.game.element.Element;
import com.g56.model.game.element.creature.Creature;
import com.g56.model.game.element.powerup.strategies.PowerupStrategy;

public class Powerup extends Element {
    private PowerupObserver observer;
    private final int duration;
    private final long appearTime;
    private PowerupStrategy strategy;

    public Powerup(Position position, int duration) {
        super(position);
        this.duration = duration;
        this.appearTime = System.currentTimeMillis();
    }

    public void setObserver(PowerupObserver observer) {
        this.observer = observer;
    }

    public void setStrategy(PowerupStrategy strategy) {
        this.strategy = strategy;
    }

    public void catchPowerup(Creature creature){
        strategy.execute(creature);
        notifyObserver();
    }

    @Override
    public boolean explode(int power) {
        notifyObserver();
        return true;
    }

    private void notifyObserver(){
        observer.toRemove(this);
    }

    public long timeToRemove(long time){
        return duration - (time - appearTime);
    }

    public int getPowerupType() {
        return strategy.getPowerupType();
    }

    public boolean isIncrement() {
        return strategy.isIncrement();
    }
}
