package com.g56.model.game.element.bomb;

public abstract class BombState {
    protected Bomb bomb;

    public BombState(Bomb bomb) {
        this.bomb = bomb;
    }

    abstract public void changeState();

    abstract public long timeToChange(long currTime);

    //returns true if bomb is isExploded
    abstract public boolean isExploded();
}
